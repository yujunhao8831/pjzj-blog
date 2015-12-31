package com.blog.redis.handler.string.impl;


import com.blog.redis.annotation.Delete;
import com.blog.redis.annotation.Get;
import com.blog.redis.annotation.Set;
import com.blog.redis.dao.StringRedis;
import com.blog.redis.handler.string.StringHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * com.redis.aop.handler
 *
 * @author : 余峻豪
 * @date : 15/12/25
 */
@Component
public class StringHandlerImpl implements StringHandler {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private StringRedis redis;

    @Override
    public Object handlerGet(final ProceedingJoinPoint point, final Method method, final Get get) throws Throwable {
        try {
            logger.info("StringHandler-handlerGet");
            // TODO 具体操作在这里
            // 如果没有开启缓存
            if (!get.isCacheEnable()) return point.proceed();

            // 被代理的目标Class名
            final String targetClassName = point.getTarget().getClass().getSimpleName();

            final String key = buildKey(targetClassName,get.namespace(), get.assignedKey());
            logger.info("Redis中缓存key = " + key);

            // 如果缓存中已经存在,直接使用缓存中的数据
            if (redis.exists(key)) {
                final String redisData = redis.get(key);
                logger.info("缓存中已经存在,直接使用缓存中的数据");
                logger.info("缓存中的数据为:" + redisData );
                return redisData;
            }

            // 如果不存在那么就调用代理方法,然后存放到Redis中
            final Object value = point.proceed();

            // 代理方法结果为null,那么直接返回
            if (null == value)  return point.proceed();

            // 设置到Redis中
            redis.set(key, (String) value, get.timeOut());
            logger.info("缓存中不存在,那么以" + key + "为key,设置到缓存中,value为 : " + value + "缓存有效时间(单位 : 1/1秒,0 : 表示永久有效)为:" + get.timeOut() );
            // 返回
            return value;
        } catch (Exception e) {
            logger.error("代理失败");
            logger.error(e);
            throw e;
        }
    }

    @Override
    public Object handlerSet (ProceedingJoinPoint point, Method method, Set set) throws Throwable {
        try {
            logger.info("StringHandler-handlerSet");
            /**
             * 目前处理方式和Delete处理方式一致,暂时性
             */
            // 如果没有开启缓存
            if (!set.isCacheEnable()) return point.proceed();
            // 被代理的目标Class名
            final String targetClassName = point.getTarget().getClass().getSimpleName();
            // key
            final String key = buildKey(targetClassName, set.namespace(), set.assignedKey());
            logger.info("Redis中缓存key = " + key);

            // 如果用户此时进行update或者insert操作,为了避免脏读
            // 删除该key在Redis中的缓存数据即可.
            final Long deleteResult = redis.delete(key);
            logger.info("删除在缓存中的内容, key = " + key);
            logger.info("删除结果 deleteResult = " + deleteResult);

            return point.proceed();
        } catch (Exception e) {
            logger.error("代理失败");
            logger.error(e);
            throw e;
        }
    }

    @Override
    public Object handlerDelete (ProceedingJoinPoint point, Method method, Delete delete) throws Throwable {
        try {
            logger.info("StringHandler-handlerDelete");
            // 如果没有开启缓存
            if (!delete.isCacheEnable()) return point.proceed();
            // 被代理的目标Class名
            final String targetClassName = point.getTarget().getClass().getSimpleName();
            // key
            final String key = buildKey(targetClassName, delete.namespace(), delete.assignedKey());
            logger.info("Redis中缓存key = " + key);

            final Long deleteResult = redis.delete(key);
            logger.info("删除在缓存中的内容, key = " + key);
            logger.info("删除结果 deleteResult = " + deleteResult);
            return point.proceed();
        } catch (Exception e) {
            logger.error("代理失败");
            logger.error(e);
            throw e;
        }
    }

    // 目标方法Class名 + 命名空间 + key 为了避免名字冲突
    private String buildKey (String targetClassName,String namespace,String assignedKey) {
        return targetClassName + "-" + namespace + "-" + assignedKey;
    }


}









