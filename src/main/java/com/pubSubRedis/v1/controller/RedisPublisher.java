package com.pubSubRedis.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class RedisPublisher {

    private final StringRedisTemplate redisTemplate;

    @PostMapping
    public void publish(@RequestParam String message){
      //  redisTemplate.convertAndSend("live-news",message);
      //  redisTemplate.convertAndSend("live-sports-news",message.toLowerCase());

        redisTemplate.convertAndSend("live-news",message);
    }
}
