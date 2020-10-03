package com.qf.j2003.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Service;


/**
 * from queue (name="topic.messge")
 * Created by jeffrey on 2020/9/21.
 */
@Service
@RabbitListener(queues = "topic.message")
@Slf4j

public class ConsumerFromTopicQueue {
    @RabbitHandler
    public void acceptMsg(String msg){
        log.info("-------topic.Message queue :"+msg);
    }


}
