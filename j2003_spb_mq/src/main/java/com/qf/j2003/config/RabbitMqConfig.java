package com.qf.j2003.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
  // 创建消息队列
  @Bean(name = "queue1")
  public Queue topicQueue() {
    return new Queue("topic.message");
  }
  //    创建topic的消息队列(messages)
  @Bean(name = "queue2")
  public Queue topicQueue2() {
    return new Queue("topic.messages");
  }
  //    创建topic类型的交换机
  @Bean(name = "topicExchange")
  public TopicExchange topicExchange() {
    return new TopicExchange("topicExchange");
  }
  //    将topic交换机和两个消息队绑定(将topic.message与交换机绑定)
  @Bean
  public Binding bingTopicMessage(
      @Qualifier("queue1") Queue queue1, @Qualifier("topicExchange") TopicExchange topicExchange) {
    return BindingBuilder.bind(queue1).to(topicExchange).with("topic.message");
  }
  //    将topic交换机和两个消息队绑定(将topic.messages与交换机绑定)
  @Bean
  public Binding bingTopicMessages(
      @Qualifier("queue2") Queue queue2, @Qualifier("topicExchange") TopicExchange topicExchange) {
    return BindingBuilder.bind(queue2)
        .to(topicExchange)
        //                exchange与队列的匹配规则
        .with("topic.messagess");
  }
}