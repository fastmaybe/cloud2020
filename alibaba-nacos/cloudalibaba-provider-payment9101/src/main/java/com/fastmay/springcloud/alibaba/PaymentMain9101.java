package com.fastmay.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: liulang
 * @Date: 2021/1/14 18:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9101 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9101.class,args);
    }
}
