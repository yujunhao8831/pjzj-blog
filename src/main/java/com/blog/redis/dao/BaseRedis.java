package com.blog.redis.dao;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.Transaction;

/**
 * @author : 余峻豪
 * @date : 15/12/24
 */
public abstract class BaseRedis {

    /**
     *
     *  切片池,集群考虑.
     *  @Autowired
     *  private ShardedJedisPool shardedJedisPool;
     */

    // 非切片池,默认不支持事务
    @Autowired
    private ShardedJedis shardedJedis;


    // 该API可支持事务
    /**
     *  如何使用事务?
     *  Transaction transaction = jedis.multi(); // 开启事务
     *  // transaction.set("","");
     *  // ... ...
     *  transaction.exec(); // 执行
     *  or
     *  // jedis.unwatch(); 取消事务
     *  // jedis.watch("key"); 标记所有指定的key 被监视起来，在事务中有条件的执行（乐观锁）。
     */
    @Autowired
    private Jedis jedis;

    public ShardedJedis getRedis () {
        return shardedJedis;
    }

    public Jedis getJedis () {
        return jedis;
    }
}
