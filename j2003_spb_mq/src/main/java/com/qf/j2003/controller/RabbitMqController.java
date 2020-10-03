package com.qf.j2003.controller;

import com.qf.j2003.service.FanoutsendExchange;
import com.qf.j2003.service.TopicSendMessage;
import com.qf.j2003.vo.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RabbitMqController {
    @Autowired
    private TopicSendMessage topicSendMessage;
    @Autowired
    private FanoutsendExchange fanoutsendExchange;
    @RequestMapping("/send")
    public String sendTotopicExchange(String msg){
        topicSendMessage.send2TopicExchange(msg);

        log.info("send to topicExchange ok");

        return "ok";

    }
    @RequestMapping("/sendf")
    public String sendToFanoutExchange(UserInfo info){
        fanoutsendExchange.send2FanoutMsg(info);
        log.info("send to send2FanoutMsg ok");
        return "ok";
    }
}
