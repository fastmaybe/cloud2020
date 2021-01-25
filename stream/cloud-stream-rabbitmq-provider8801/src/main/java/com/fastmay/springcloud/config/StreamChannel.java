package com.fastmay.springcloud.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Author: liulang
 * @Date: 2021/1/12 19:07
 */

public interface  StreamChannel {
    // 这里可以定义不同的通道
    String DY_SENDER_TOPIC = "dyOutPutTopic";
    String DY_SENDER_DIRECT = "dyOutPutDirect";


    @Output(StreamChannel.DY_SENDER_TOPIC)
    public MessageChannel dyOutPutTopic();

    @Output(StreamChannel.DY_SENDER_DIRECT)
    public MessageChannel dyOutPutDirect();
}
