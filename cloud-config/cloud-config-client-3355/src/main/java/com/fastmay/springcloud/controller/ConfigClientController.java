package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.config.DbConfig;
import com.fastmay.springcloud.config.DbConfig2;
import com.fastmay.springcloud.dao.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liulang
 * @Date: 2021/1/11 14:47
 */
@RestController
//@RefreshScope
public class ConfigClientController {

    @Autowired(required = false)
    private DbConfig dbConfig;

    @Autowired(required = false)
    private DbConfig2 dbConfig2;

    @Autowired(required = false)
    private com.fastmay.springcloud.dao.PaymentMapper paymentMapper;

    @RequestMapping("config")
    public DbConfig dbConfig(){
        return dbConfig;
    }

    @RequestMapping("config2")
    public Object dbConfig2(){
        return paymentMapper.selectByPrimaryKey(1L);
    }


}
