package com.wayne.kafka;

import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Wayne
 * @date 2018/3/9
 * <p>
 * desc: kafka消费者监听
 */
@Component
public class KafkaAdminConsumerListener {

    @KafkaListener(topics = KafkaTopicConstant.USER_KAFKA_TOPIC)
    public void processMessage(String message) {
        KafkaMessage kafkaMessage = new Gson().fromJson(message, KafkaMessage.class);
        System.out.println(kafkaMessage.getTag());
        System.out.println(kafkaMessage.getData());
    }
}
