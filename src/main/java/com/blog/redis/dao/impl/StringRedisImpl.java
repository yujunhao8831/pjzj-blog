package com.blog.redis.dao.impl;


import com.blog.redis.dao.BaseRedis;
import com.blog.redis.dao.StringRedis;
import org.springframework.stereotype.Repository;

/**
 * com.redis.aop.dao.impl
 * @author : 余峻豪
 * @date : 15/12/24
 */
@Repository
public class StringRedisImpl extends BaseRedis implements StringRedis {


    @Override
    public String set (String key, String value, int timeOut) throws Exception {
        try {
            String result = getRedis().set(key, value);
            if ( timeOut > 0 )  getRedis().expire(key, timeOut);
            return result;
        } catch ( Exception e ) {
            throw e;
        }
    }


    @Override
    public String get (String key)  {
        try {

            return getRedis().get(key);
        } catch ( Exception e ) {
            throw e;
        }
    }

    @Override
    public Long delete (String key) throws Exception {
        try
        {
            return getRedis().del(key);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean exists (String key) throws Exception {
        try
        {
            return getRedis().exists(key);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Long append (String key, String value) throws Exception {
        try {
            return getRedis().append(key,value);
        } catch (Exception e) {
            throw e;
        }
    }


}
