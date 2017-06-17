package com.lb.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//@Configuration
//@EnableRedisHttpSession
public class RedisSentinelApplicationConfig {
    static final RedisSentinelConfiguration SENTINEL_CONFIG = new RedisSentinelConfiguration().master("mymaster")
            .sentinel("127.0.0.1", 3306);
//            .sentinel("172.30.34.144", 26380);
    @Bean(value = "redisTemplate")
    public <Object> RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(connectionFactory());
        // 开启事务支持
        redisTemplate.setEnableTransactionSupport(true);
        // 使用String格式序列化缓存键
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return redisTemplate;
    }
    @Bean
    public  RedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory(sentinelConfig());
    }
    @Bean
    public  RedisSentinelConfiguration sentinelConfig() {
        return SENTINEL_CONFIG;
    }
    /*@Bean
    public MyHttpSessionLisener myHttpSessionLisener(){
        return new MyHttpSessionLisener();
    }
    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter(){
        List<HttpSessionListener> listeners = new ArrayList<>();
        listeners.add(myHttpSessionLisener());
        return new SessionEventHttpSessionListenerAdapter(listeners);
    }*/
}
