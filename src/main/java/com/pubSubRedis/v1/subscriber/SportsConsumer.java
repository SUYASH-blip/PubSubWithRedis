package com.pubSubRedis.v1.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SportsConsumer implements MessageListener {
    @Override
    public void onMessage(Message message, byte @Nullable [] pattern) {
        String body = new String(message.getBody());
        String channel = new String(message.getChannel());
        log.info("Message received with channel:{} and body:{}",channel,body);
    }
}
