package com.fastmay.springcloud.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liulang
 * @Date: 2021/1/8 14:01
 */
@Configuration
public class HystrixConfig {



    // 开启hystrix超时时间，默认1000ms，如今为4000ms
    /**根据官网配置
     * 全局断路器配置  这里配置不生效  暂未找到原因
     * @return
     */
//    @Bean
//    public Customizer<HystrixCircuitBreakerFactory> defaultConfig() {
//        return new Customizer<HystrixCircuitBreakerFactory>() {
//            @Override
//            public void customize(HystrixCircuitBreakerFactory factory) {
//
//                factory.configureDefault(id -> HystrixCommand.Setter
//                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(id))
//                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//                                .withExecutionTimeoutInMilliseconds(4000)));
//            }
//        };
//    }


}
