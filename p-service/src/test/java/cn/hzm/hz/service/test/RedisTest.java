package cn.hzm.hz.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hzm.hz.redis.RedisClientTemplate;
import cn.hzm.hz.test.BaseTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisTest extends BaseTest{


	
	@Autowired
	private RedisClientTemplate redisClientTemplate;
	
	@Test
	public void tests(){
		String key = "test1";  
        int seconds = 10;  
       // Jedis jedis = new Jedis("127.0.0.1", 6379);
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis);  
        String ping = jedis.ping();  
        System.out.println(ping);
        redisClientTemplate.set(key, "test1value2"); 
        System.out.println(redisClientTemplate.get(key));
        System.out.println(redisClientTemplate.get("test"));
        jedis.set("rrr","1");
        System.out.println(jedis.get("rrr"));
       /* redisClientTemplate.expire(key, seconds); 
        System.out.println(redisClientTemplate.get(key));*/
       
	}
	
	//s事务
	@Test
	public void test1(){
		Jedis jedis = new Jedis("127.0.0.1", 6379);
        Transaction  t = jedis.multi();
        t.set("k5", "v5");
        t.set("k6", "v6");
        t.exec();
        System.out.println(jedis.get("k5"));
        System.out.println(t.get("k6"));
       
	}
}
