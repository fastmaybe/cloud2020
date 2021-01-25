package com.fastmay.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: liulang
 * @Date: 2020/12/29 11:31
 */
@SpringBootApplication
@MapperScan("com.fastmay.springcloud.dao")
@EnableEurekaClient
public class PaymentMain8012 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8012.class,args);
    }
}
