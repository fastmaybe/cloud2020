package com.fastmay.springcloud.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @Author: liulang
 * @Date: 2021/1/13 11:00
 */

public interface  StreamChannel {
    // 这里可以定义不同的通道
    String DY_RECEVER_TOPIC = "dyInPutTopic";
    String DY_RECEVER_DIRECT = "dyInPutDirect";


    @Input(StreamChannel.DY_RECEVER_TOPIC)
    public MessageChannel dyInPutTopic();

    @Input(StreamChannel.DY_RECEVER_DIRECT)
    public MessageChannel dyInPutDirect();
}

