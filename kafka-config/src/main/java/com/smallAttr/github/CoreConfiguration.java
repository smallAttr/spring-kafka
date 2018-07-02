package com.smallAttr.github;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenGang
 * @Date: 2018/6/28 下午2:19
 * @Description:
 */
@Configuration
@EnableKafka
public class CoreConfiguration {

    @Value("${spring.kafka.server}")
    private String kafkaServer;


    @Value("${spring.kafka.port}")
    private String port;


    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer + ":" + port);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("small", 10, (short) 2);
    }
}
