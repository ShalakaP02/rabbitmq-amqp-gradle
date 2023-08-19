package com.shalaka.practicerabbitmq.consumer;

import com.shalaka.practicerabbitmq.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumerTwo {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqConsumerTwo.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user){
        logger.info(String.format("Json message received -> %s",user.toString()));
    }
}
