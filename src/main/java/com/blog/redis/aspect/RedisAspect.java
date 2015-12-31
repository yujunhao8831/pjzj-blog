package com.blog.redis.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : 余峻豪
 * @date : 15/12/24
 * Redis AOP 操作切入点为 : Get Set Delete 3个注解,采用 环绕 方式
 */
@Aspect
@Component
class RedisAspect extends AbstractRedisAspect {

    // 切入点为Get注解
    @Pointcut("@annotation(com.blog.redis.annotation.Get)")
    public void pointcutGet() {}

    // 环绕通知 处理
    @Around("pointcutGet()")
    public Object doGetService (final ProceedingJoinPoint point)  {
        return super.doGetDispatch(point);
    }
    // ----------------------------------------------------------------
    // 切入点为Set注解
    @Pointcut("@annotation(com.blog.redis.annotation.Set)")
    public void pointcutSet() {}

    // 环绕通知 处理
    @Around("pointcutSet()")
    public Object doSetService (final ProceedingJoinPoint point)  {
        return super.doSetDispatch(point);
    }
    // ----------------------------------------------------------------
    // 切入点为Delete注解
    @Pointcut("@annotation(com.blog.redis.annotation.Delete)")
    public void pointcutDelete() {}

    // 环绕通知 处理
    @Around("pointcutDelete()")
    public Object doDeleteService (final ProceedingJoinPoint point)  {
        return super.doDeleteDispatch(point);
    }

}
















