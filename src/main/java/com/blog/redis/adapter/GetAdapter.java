package com.blog.redis.adapter;


import com.blog.redis.annotation.Get;
import com.blog.redis.annotation.RedisType;
import com.blog.redis.handler.object.ObjectHandler;
import com.blog.redis.handler.string.StringHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 * @author : 余峻豪
 * @date : 15/12/28
 */
@Component
public class GetAdapter {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private StringHandler stringHandler;
    @Autowired
    private ObjectHandler objectHandler;

    public Object handler (ProceedingJoinPoint point, Method method, Get get) throws Throwable {
        logger.info("GetAdapter-handler");
        if (RedisType.String == get.cacheType()) return stringHandler.handlerGet(point, method, get);
        if (RedisType.Object == get.cacheType()) return objectHandler.handlerGet(point, method, get);
        return point.proceed();
    }

}














