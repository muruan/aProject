package cn.hzm.hz.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
@Component("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {  
	  
    protected final Logger log = LoggerFactory.getLogger(getClass());  
  
    @Autowired
    private ShardedJedisPool shardedJedisPool;  
  
    @Override  
    public ShardedJedis getRedisClient() {  
        try {  
            return shardedJedisPool.getResource();  
        } catch (Exception e) {  
            log.error("getRedisClent error", e);  
           // if (null != shardedJedisPool.getResource())
            //	shardedJedisPool.getResource().close();
        }  
        return null;  
    }  
  
    @Override  
    public void returnResource(ShardedJedis shardedJedis) {  
//       shardedJedisPool.returnResource(shardedJedis);  
        shardedJedis.close();  
    }  
  
    @Override  
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {  
        // if (broken) {  
        // shardedJedisPool.returnBrokenResource(shardedJedis);  
        // } else {  
        // shardedJedisPool.returnResource(shardedJedis);  
        // }  
        returnResource(shardedJedis);  
    }  
  
    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {  
        this.shardedJedisPool = shardedJedisPool;  
    }  
      
}  