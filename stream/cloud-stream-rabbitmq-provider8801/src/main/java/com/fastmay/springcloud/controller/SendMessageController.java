package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liulang
 * @Date: 2021/1/12 17:27
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;


    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

    @GetMapping(value = "/sendMessagedy")
    public String sendMessageDy()
    {
        return messageProvider.dyOutPutSend();
    }
}

