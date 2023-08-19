package com.shalaka.practicerabbitmq.publisher;

import com.shalaka.practicerabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducerTwo {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqProducerTwo.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMqProducerTwo(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        rabbitTemplate.convertAndSend(exchangeName,routingJsonKey,user);
        logger.info(String.format("Json message sent -> %s",user.toString()));
    }
}
