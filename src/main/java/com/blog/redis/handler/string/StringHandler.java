package com.blog.redis.handler.string;


import com.blog.redis.annotation.Delete;
import com.blog.redis.annotation.Get;
import com.blog.redis.annotation.Set;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * Redis中对String的处理
 * @author : 余峻豪
 * @date : 15/12/25
 */
public interface StringHandler {
    /**
     * redis操作
     * @param point   : 代理
     * @param method  : 被代理的方法
     * @param get     : 被代理的方法上的注解
     * @return
     * @throws Exception
     */
    Object handlerGet (final ProceedingJoinPoint point, final Method method, final Get get) throws Throwable;

    /**
     * redis操作
     * @param point   : 代理
     * @param method  : 被代理的方法
     * @param set     : 被代理的方法上的注解
     * @return
     * @throws Exception
     */
    Object handlerSet (final ProceedingJoinPoint point, final Method method, final Set set) throws Throwable;

    /**
     * redis操作
     * @param point   : 代理
     * @param method  : 被代理的方法
     * @param delete  : 被代理的方法上的注解
     * @return
     * @throws Exception
     */
    Object handlerDelete (final ProceedingJoinPoint point, final Method method, final Delete delete) throws Throwable;



}
