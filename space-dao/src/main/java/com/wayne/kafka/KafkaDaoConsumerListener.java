package com.wayne.kafka;

import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author wayne
 * @date 2018/5/16 17:16
 * <p>
 * description: kafka消费者监听
 */
@Component
public class KafkaDaoConsumerListener {

    @KafkaListener(topics = KafkaTopicConstant.ADMIN_KAFKA_TOPIC)
    public void processMessage(String message) {
        KafkaMessage kafkaMessage = new Gson().fromJson(message, KafkaMessage.class);
        System.out.println(kafkaMessage.getTag());
        System.out.println(kafkaMessage.getData());
    }
}
