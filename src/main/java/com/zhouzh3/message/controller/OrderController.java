package com.zhouzh3.message.controller;

import com.zhouzh3.message.mq.producer.OrderProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author haig
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @RequestMapping("/send")
    public String send(/*@RequestParam(name = "message", defaultValue = "hello world") String message*/) {
        String newMessage = "发送消息: " + LocalDateTime.now();
        System.out.println("=======send" + newMessage);
        orderProducer.send(Map.of("message", newMessage));

        return newMessage;
    }

}
