package com.blog.redis.adapter;


import com.blog.redis.annotation.RedisType;
import com.blog.redis.annotation.Set;
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
public class SetAdapter {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private StringHandler stringHandler;
    @Autowired
    private ObjectHandler objectHandler;

    public Object handler (ProceedingJoinPoint point, Method method, Set set) throws Throwable {
        logger.info("SetAdapter-handler");
        if (RedisType.String == set.cacheType()) return stringHandler.handlerSet(point, method, set);
        if (RedisType.Object == set.cacheType()) return objectHandler.handlerSet(point, method, set);
        return point.proceed();
    }

}









