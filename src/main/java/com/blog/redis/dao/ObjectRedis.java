package com.blog.redis.dao;

/**
 * @author : 余峻豪
 * @date : 15/12/24
 * <p>
 *  操作Redis数据结构-字符串(String),以byte形式存储.<br/>
 *  用于对Object的操作 <br/>
 *  可以是Java中 : List Map Set POJO类型
 * <p/>
 * @link : http://www.redis.cn/commands.html
 */
public interface ObjectRedis {

    /**
     * 设置对象到缓存中
     * @param key       : 键
     * @param object    : 对象
     * @param timeOut   : 失效时间
     * @throws Exception
     */
    String set (final String key, final Object object, final int timeOut) throws Exception;

    /**
     * 得到一个对象
     * @param key : 该对象key
     * @param <T> : 该对象类型
     * @return
     * @throws Exception
     */
    <T> T get (final String key) throws Exception;

    /**
     * 删除
     * @param key
     * @return
     * @throws Exception
     */
    Long delete (final String key) throws Exception;

    /**
     * 判断一个key是否存在
     * @param key
     * @return
     * @throws Exception
     */
    boolean exists (final String key) throws Exception;
}
