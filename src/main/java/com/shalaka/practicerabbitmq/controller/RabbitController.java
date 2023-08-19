package com.shalaka.practicerabbitmq.controller;

import com.shalaka.practicerabbitmq.dto.User;
import com.shalaka.practicerabbitmq.publisher.RabbitMqProducerOne;
import com.shalaka.practicerabbitmq.publisher.RabbitMqProducerTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RabbitController {

    private RabbitMqProducerOne rabbitMqProducerOne;

    private RabbitMqProducerTwo rabbitMqProducerTwo;

    public RabbitController(){

    }

    public RabbitController(RabbitMqProducerOne rabbitMqProducerOne) {
        this.rabbitMqProducerOne = rabbitMqProducerOne;
    }

    @Autowired
    public RabbitController(RabbitMqProducerTwo rabbitMqProducerTwo) {
        this.rabbitMqProducerTwo = rabbitMqProducerTwo;
    }

    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMqProducerOne.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMq...");
    }

    @PostMapping("/publishJson")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMqProducerTwo.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to RabbitMq...");
    }
}
