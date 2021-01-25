package com.fastmay.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: liulang
 * @Date: 2021/1/13 17:20
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.fastmay.springcloud.dao")
public class SleuthProviderPay8011 {
    public static void main(String[] args) {

        SpringApplication.run(SleuthProviderPay8011.class,args);
    }
}
