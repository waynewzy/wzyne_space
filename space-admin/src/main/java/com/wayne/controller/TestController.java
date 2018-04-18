package com.wayne.controller;

import com.google.gson.Gson;
import com.wayne.http.HttpUtil;
import com.wayne.http.Response;
import com.wayne.kafka.KafkaMessage;
import com.wayne.kafka.KafkaMessageType;
import com.wayne.kafka.KafkaProducer;
import com.wayne.kafka.KafkaTopicConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wayne
 * @date 2018/3/10
 * <p>
 * desc: 测试controller
 */
@RestController
public class TestController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/kafka")
    public Response kafkaTest() {
        KafkaMessage kafkaMessage = new KafkaMessage(KafkaMessageType.KAFKA_MESSAGE_TEST,"kafka测试");
        kafkaProducer.sendMessage(KafkaTopicConstant.ADMIN_KAFKA_TOPIC,new Gson().toJson(kafkaMessage));
        return HttpUtil.ResponseSuccess();
    }
}
