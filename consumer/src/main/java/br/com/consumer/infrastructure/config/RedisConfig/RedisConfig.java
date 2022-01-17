package br.com.consumer.infrastructure.config.RedisConfig;

import br.com.consumer.user.UserRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory connectionJedisFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
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
