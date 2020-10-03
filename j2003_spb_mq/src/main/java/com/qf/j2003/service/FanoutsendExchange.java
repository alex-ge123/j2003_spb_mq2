package com.qf.j2003.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jeffrey on 2020/9/21.
 */
@Component
@Slf4j
public class FanoutsendExchange {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send2FanoutMsg(Object msg){
        log.info("=====sent2fanout:"+ msg);
        rabbitTemplate.convertAndSend("fanoutExchange","",msg);
    }

}
