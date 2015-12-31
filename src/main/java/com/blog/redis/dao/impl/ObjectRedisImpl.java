package com.blog.redis.dao.impl;


import com.blog.redis.dao.BaseRedis;
import com.blog.redis.dao.ObjectRedis;
import com.blog.redis.utils.SerializeUtil;
import org.springframework.stereotype.Repository;

/**
 * @author : 余峻豪
 * @date : 15/12/28
 */
@Repository
public class ObjectRedisImpl extends BaseRedis implements ObjectRedis {

    @Override
    public String set (String key, Object object, int timeOut) throws Exception {
        try {
            String result = getRedis().set(key.getBytes(), SerializeUtil.serialize(object));
            if ( timeOut > 0 )  getRedis().expire(key.getBytes(), timeOut);
            return result;
        } catch ( Exception e ) {
            throw e;
        }
    }


    @Override
    public <T> T get (String key) throws Exception {
        try {
            final byte[] bytes = getRedis().get(key.getBytes());
            return (T) SerializeUtil.deserialize(bytes);
        } catch ( Exception e ) {
            throw e;
        }
    }

    @Override
    public Long delete (String key) throws Exception {
        try {
            return getRedis().del(key.getBytes());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean exists (String key) throws Exception {
        try {
            return getRedis().exists(key.getBytes());
        } catch (Exception e) {
            throw e;
        }
    }
}
