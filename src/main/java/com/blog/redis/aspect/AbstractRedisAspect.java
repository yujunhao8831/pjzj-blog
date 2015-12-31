package com.blog.redis.aspect;


import com.blog.redis.adapter.DeleteAdapter;
import com.blog.redis.adapter.GetAdapter;
import com.blog.redis.adapter.SetAdapter;
import com.blog.redis.annotation.Delete;
import com.blog.redis.annotation.Get;
import com.blog.redis.annotation.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author : 余峻豪
 * @date : 15/12/25
 */
public abstract class AbstractRedisAspect {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private GetAdapter getAdapter;

    @Autowired
    private SetAdapter setAdapter;

    @Autowired
    private DeleteAdapter deleteAdapter;


    // 查询的处理
    protected Object doGetDispatch (ProceedingJoinPoint point) {
        logger.info("doGetDispatch");
        try {
            // 通过代理对象得到所代理的方法
            Method method = ((MethodSignature) point.getSignature()).getMethod();
            final Get get = method.getAnnotation(Get.class);
            logger.info("对被" + get + "注解的方法进行代理操作." );
            logger.info("被代理的方法为 " + method.getName());
            return getAdapter.handler(point, method, get);
        } catch (Exception e) {
            logger.error(e);
            return e;
        } catch (Throwable throwable) {
            logger.error(throwable);
            return throwable;
        }

    }

    // 更新/插入的处理
    protected Object doSetDispatch (ProceedingJoinPoint point) {
        logger.info("doSetDispatch");
        try {
            // 通过代理对象得到所代理的方法
            Method method = ((MethodSignature) point.getSignature()).getMethod();
            final Set set = method.getAnnotation(Set.class);
            logger.info("对被" + set + "注解的方法进行代理操作." );
            logger.info("被代理的方法为 " + method.getName());
            return setAdapter.handler(point, method, set);
        } catch (Exception e) {
            logger.error(e);
            return e;
        } catch (Throwable throwable) {
            logger.error(throwable);
            return throwable;
        }
    }

    // 删除的处理
    protected Object doDeleteDispatch (ProceedingJoinPoint point) {
        logger.info("doDeleteDispatch");
        try {
            // 通过代理对象得到所代理的方法
            Method method = ((MethodSignature) point.getSignature()).getMethod();
            final Delete delete = method.getAnnotation(Delete.class);
            logger.info("对被" + delete + "注解的方法进行代理操作." );
            logger.info("被代理的方法为 " + method.getName());
            return deleteAdapter.handler(point, method, delete);
        } catch (Exception e) {
            logger.error(e);
            return e;
        } catch (Throwable throwable) {
            logger.error(throwable);
            return throwable;
        }
    }


    @Deprecated
    private Method getMethod (ProceedingJoinPoint point) throws NoSuchMethodException {
        // 得到代理对象的参数列表
        final Object[] args = point.getArgs();
        // 构建参数类型列表
        Class[] parameterTypes = new Class[args.length];
        int index = 0;
        for (Object object : args) {
            parameterTypes[index++] = object.getClass();
        }
        // 得到所代理的目标对象
        final Object target = point.getTarget();
        // 得到目标对象所被代理的方法
        Method method = target.getClass().getMethod(point.getSignature().getName(), parameterTypes);
        return method;
    }



}
