package com.smallAttr.github.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * @Author: chenGang
 * @Date: 2018/7/2 下午4:14
 * @Description:
 */
public class KafkaReceiver {

    @KafkaListener(topics = {"test-topic"})
    public void listen(ConsumerRecord<String, String> record) {
        Optional<String> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String message = kafkaMessage.get();
            System.out.println("listen1 " + message);
        }
    }
}
