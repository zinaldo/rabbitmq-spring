package com.example.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	public TestController(AmqpTemplate queueSender) {
		this.queueSender = queueSender;
	}

	private final AmqpTemplate queueSender;

    @GetMapping
    public String send(){
        queueSender.convertAndSend("test-exchange", "test-queue-rk", "test message");
        return "ok. done";
    }

}
