package br.com.consumer.infrastructure.config.RedisConfig;

import br.com.consumer.user.UserRedis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String hostRedis;

    @Value("${spring.redis.port}")
    private Integer portRedis;

    @Bean
    public JedisConnectionFactory connectionJedisFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(hostRedis, portRedis);
        return new JedisConnectionFactory(config);

    }

    @Bean
    RedisTemplate<String, UserRedis> redisTemplate(){
        RedisTemplate<String,UserRedis> redisTemplate = new RedisTemplate<String, UserRedis>();
        redisTemplate
                .setConnectionFactory(connectionJedisFactory());
        return redisTemplate;
    }

}
