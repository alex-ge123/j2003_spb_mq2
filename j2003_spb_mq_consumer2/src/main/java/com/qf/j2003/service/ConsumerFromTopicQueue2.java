package com.qf.j2003.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * from queue (name="topic.messge")
 * Created by jeffrey on 2020/9/21.
 */
@Service
@RabbitListener(queues = "topic.messages")
@Slf4j

public class ConsumerFromTopicQueue2 {
    @RabbitHandler
    public void acceptMsg(String msg){
        log.info("topic.Messagessssss queue :"+msg);
    }
}
