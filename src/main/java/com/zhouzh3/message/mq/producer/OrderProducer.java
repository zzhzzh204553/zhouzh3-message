package com.zhouzh3.message.mq.producer;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;

/**
 * @author haig
 */
@Slf4j
@Configuration
public class OrderProducer {

    private final StreamBridge streamBridge;

    public OrderProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    public boolean send(Object message) {
        log.info("=========生产者========send message:{}", message);
        if (message == null) {
            return false;
        }

        // "outputChannel" 对应配置的绑定
        return streamBridge.send("producer-out-0", JSON.toJSONString(message));
    }


}
