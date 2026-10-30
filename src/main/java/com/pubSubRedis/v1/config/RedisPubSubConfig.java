package com.pubSubRedis.v1.config;

import com.pubSubRedis.v1.subscriber.GeneralConsumer;
import com.pubSubRedis.v1.subscriber.RedisConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisPubSubConfig {


    /*
    This is to configure which subscriber to trigger for which channel
     */
    @Bean
    public RedisMessageListenerContainer config(RedisConnectionFactory redisConnectionFactory,
                                                //  RedisConsumer redisConsumer,
                                                GeneralConsumer generalConsumer){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
       // container.addMessageListener(redisConsumer,new ChannelTopic("live-news"));
        container.addMessageListener(generalConsumer,new PatternTopic("live-*"));
        return container;
    }
}
