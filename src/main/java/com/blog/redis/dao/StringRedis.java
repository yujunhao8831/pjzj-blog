package com.blog.redis.dao;

/**
 * com.redis.aop.dao
 * @author : 余峻豪
 * @date : 15/12/24
 * 操作Redis数据结构-字符串(String)
 * @link : http://www.redis.cn/commands.html
 */
public interface StringRedis {

    /**
     * 设置缓存
     * @param key       : 键
     * @param value     : 值
     * @param timeOut   : 失效时间
     * @throws Exception
     */
    String set (final String key, final String value, final int timeOut) throws Exception;

    /**
     * 得到一个值
     * @param key
     * @return
     * @throws Exception
     */
    String get (final String key) throws Exception;

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

    /**
     * 如果 key 已经存在，并且值为字符串，那么这个命令会把 value 追加到原来值（value）的结尾。
     * 如果 key 不存在，那么它将首先创建一个空字符串的key，再执行追加操作，
     * 这种情况 APPEND 将类似于 SET 操作
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    Long append (final String key, final String value) throws Exception;





}
