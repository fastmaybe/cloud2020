package com.fastmay.springcloud;

import com.fastmay.myrule.DyRule;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @Author: liulang
 * @Date: 2020/12/30 13:57
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = DyRule.class)
public class OrderFeignOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignOrder80.class,args);

    }

    /**
     * 日志增强
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
