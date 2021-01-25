package com.fastmay.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: liulang
 * @Date: 2020/12/29 15:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.fastmay.springcloud.dao")
public class PaymentMainConsul8012 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMainConsul8012.class,args);
    }
}
