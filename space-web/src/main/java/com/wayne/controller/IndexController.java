package com.wayne.controller;

import com.google.gson.Gson;
import com.wayne.http.HttpUtil;
import com.wayne.http.Response;
import com.wayne.kafka.KafkaMessage;
import com.wayne.kafka.KafkaMessageType;
import com.wayne.kafka.KafkaProducer;
import com.wayne.kafka.KafkaTopicConstant;
import com.wayne.model.User;
import com.wayne.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Wayne
 * @date 2018/3/10
 * <p>
 * desc: 测试controller
 */
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/kafka")
    public Response kafkaTest() {
        KafkaMessage kafkaMessage = new KafkaMessage(KafkaMessageType.KAFKA_MESSAGE_TEST, "kafka测试");
        kafkaProducer.sendMessage(KafkaTopicConstant.USER_KAFKA_TOPIC, new Gson().toJson(kafkaMessage));
        return HttpUtil.ResponseSuccess();
    }

    @GetMapping(value = "/login")
    public String login() {
        return "/login";
    }
}
