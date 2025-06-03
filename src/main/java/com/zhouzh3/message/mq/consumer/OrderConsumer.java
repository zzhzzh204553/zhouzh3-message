package com.zhouzh3.message.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author haig
 */
@Slf4j
@Configuration
public class OrderConsumer {

    @Bean
    public Consumer<String> consumer() {
        return message -> log.info("===========Received: {}", message);
    }
}
