package com.smallAttr.github;

import com.smallAttr.github.kafka.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: chenGang
 * @Date: 2018/7/2 下午4:17
 * @Description:
 */
@SpringBootApplication
public class KafkaProducerLauncher {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaProducerLauncher.class, args);
        KafkaSender kafkaSender = (KafkaSender) context.getBean("kafkaSender");
        kafkaSender.send();
    }
}
