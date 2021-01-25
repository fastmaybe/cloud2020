package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.config.StreamChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: liulang
 * @Date: 2021/1/13 11:00
 */
@Component
@EnableBinding(StreamChannel.class)
public class DYReceiveMessageListenerController {


    @Value("${server.port}")
    private String serverPort;


    @StreamListener(StreamChannel.DY_RECEVER_TOPIC)
    public void DY_RECEVER_TOPIC(Message<String> message){
        System.err.println("消费者2号DY_RECEVER_TOPIC,----->接受到的消息: "+message.getPayload()+"\t  port: "+serverPort);
    }
    @StreamListener(StreamChannel.DY_RECEVER_DIRECT)
    public void DY_RECEVER_DIRECT(Message<String> message){
        System.err.println("消费者2号DY_RECEVER_DIRECT,----->接受到的消息: "+message.getPayload()+"\t  port: "+serverPort);
    }
}
