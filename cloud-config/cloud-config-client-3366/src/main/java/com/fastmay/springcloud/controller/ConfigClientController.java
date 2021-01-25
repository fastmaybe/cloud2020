package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.config.DbConfig;
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

    @Autowired
    private DbConfig dbConfig;

    @RequestMapping("config")
    public DbConfig dbConfig(){
        return dbConfig;
    }
}
