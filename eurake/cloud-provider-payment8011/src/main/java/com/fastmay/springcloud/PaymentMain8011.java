package com.fastmay.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: liulang
 * @Date: 2020/12/28 16:01
 */
@SpringBootApplication
@MapperScan("com.fastmay.springcloud.dao")
@EnableEurekaClient
public class PaymentMain8011 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8011.class,args);
    }
}
