package com.wayne.controller;

import com.google.gson.Gson;
import com.wayne.http.HttpUtil;
import com.wayne.http.Response;
import com.wayne.kafka.KafkaMessage;
import com.wayne.kafka.KafkaMessageType;
import com.wayne.kafka.KafkaProducer;
import com.wayne.kafka.KafkaTopicConstant;
import com.wayne.model.User;
import com.wayne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wayne
 * @date 2018/3/10
 * <p>
 * desc: 测试controller
 */
@RestController("/test")
public class TestController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/kafka",method = RequestMethod.GET)
    public Response kafkaTest() {
        KafkaMessage kafkaMessage = new KafkaMessage(KafkaMessageType.KAFKA_MESSAGE_TEST,"kafka测试");
        kafkaProducer.sendMessage(KafkaTopicConstant.ADMIN_KAFKA_TOPIC,new Gson().toJson(kafkaMessage));
        return HttpUtil.ResponseSuccess();
    }

    @RequestMapping("/addUser")
    public Response addUser() {
        User user = new User();
        user.setPassword("8888");
        user.setUserName("wayne");
        user.setPhone("188");
        userService.insert(user);
        return HttpUtil.ResponseSuccess();
    }
}
