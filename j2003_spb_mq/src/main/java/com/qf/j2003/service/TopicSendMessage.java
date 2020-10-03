package com.qf.j2003.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by jeffrey on 2020/9/21.
 */
@Component
@Slf4j
public class TopicSendMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send2TopicExchange(String msg){
        /**
         * 参数1：交换机名称
         * 参数2：routingKey  路条
         * 参数3：消息
         */
        log.info("=================send to topicExchange:"+msg);
        rabbitTemplate.convertAndSend("topicExchange","topic.message",msg);
        log.info("=================send to topicExchange:"+msg+1000);
        rabbitTemplate.convertAndSend("topicExchange","topic.mes.xxx",msg+1000);

    }
}
