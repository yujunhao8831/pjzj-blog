package com.blog.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 余峻豪 on 15/12/24.
 * Redis中get操作
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Get {
    /**
     * 命名空间
     */
    String namespace ();
    /**
     * key
     */
    String assignedKey ();

    /**
     * 默认 value 存储类型
     * @return
     */
    Class<?> valueClass () default String.class;

    /**
     * 缓存类型
     * @return
     */
    RedisType cacheType () default RedisType.String ;
    /**
     * 有效时间
     * 单位  : 1/1秒
     * 默认0 : 永久有效
     * @return
     */
    int timeOut () default 0;

    /**
     * 是否启用.
     * 默认 : 开启
     * @return
     */
    boolean isCacheEnable () default true;


}
