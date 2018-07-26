package com.junxia.redis.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author junxiawang
 * 发布消息
 */
@Service
public class PublisherService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 发布消息
     *
     * @return
     */
    public String sendMessage(String topic, String message) {
        try {
            redisTemplate.convertAndSend(topic, message);
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

    /**
     * 测试方法
     * @param name
     * @return
     */
    public String sendMessage(String name) {
        try {
            redisTemplate.convertAndSend("TOPIC_USERNAME", name);
            return "消息发送成功了";

        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了";
        }
    }

}
