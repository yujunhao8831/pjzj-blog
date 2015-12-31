package com.blog.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 余峻豪 on 15/12/27.
 * Redis中删除操作
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Delete {

    /**
     * 命名空间
     */
    String namespace ();
    /**
     * key
     */
    String assignedKey ();

    /**
     * 缓存类型
     * @return
     */
    RedisType cacheType () default RedisType.String ;

    /**
     * 是否启用.
     * 默认 : 开启
     * @return
     */
    boolean isCacheEnable () default true;
}
