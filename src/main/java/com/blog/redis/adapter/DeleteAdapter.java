package com.blog.redis.adapter;

import com.blog.redis.annotation.Delete;
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
 * @author : 余峻豪
 * @date : 15/12/28
 */
@Component
public class DeleteAdapter  {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private StringHandler stringHandler;
    @Autowired
    private ObjectHandler objectHandler;

    public Object handler (ProceedingJoinPoint point, Method method,final Delete delete) throws Throwable {
        logger.info("DeleteAdapter-handler");
        if ( RedisType.String == delete.cacheType() )  return stringHandler.handlerDelete(point, method, delete);
        if ( RedisType.Object == delete.cacheType() )  return objectHandler.handlerDelete(point, method, delete);
        return point.proceed();
    }

}
