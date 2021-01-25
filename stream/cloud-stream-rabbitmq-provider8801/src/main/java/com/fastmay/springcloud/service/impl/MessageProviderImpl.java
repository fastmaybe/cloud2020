package com.fastmay.springcloud.service.impl;

import com.fastmay.springcloud.config.StreamChannel;
import com.fastmay.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @Author: liulang
 * @Date: 2021/1/12 17:26
 */
@EnableBinding(StreamChannel.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    @Qualifier("dyOutPutTopic")
    private MessageChannel dyOutPutTopic; // 消息发送管道

    @Autowired
    @Qualifier("dyOutPutDirect")
    private MessageChannel dyOutPutDirect; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> build = MessageBuilder.withPayload(serial).build();
        dyOutPutTopic.send(build);
        System.out.println("*****serial: "+serial);
        return null;
    }

    @Override
    public String dyOutPutSend() {
        String serial = "dyOutPutSend:"+UUID.randomUUID().toString();
        Message<String> build = MessageBuilder.withPayload(serial).build();
        dyOutPutDirect.send(build);
        System.out.println("*****serial: "+serial);
        return null;
    }
}
