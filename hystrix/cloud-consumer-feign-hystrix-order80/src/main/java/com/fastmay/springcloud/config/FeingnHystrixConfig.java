package com.fastmay.springcloud.config;

import com.fastmay.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.netflix.hystrix.HystrixCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.lang.reflect.Method;

/**
 * @Author: liulang
 * @Date: 2021/1/8 15:33
 */
@Configuration
public class FeingnHystrixConfig {

//    @Bean
    public Feign.Builder feignBuilder() {
        return HystrixFeign.builder().setterFactory(new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                //特殊构造
                String name = target.name();// CLOUD-PROVIDER-HYSTRIX-PAYMENT  服务名

                String meth = method.getName();
                //可以在这里针对服务和 方法进行细化配置  demo只有一个服务 因此针对方法

//                if ("paymentInfo_TimeOut".equals(meth)){  这里特殊配置 注释调 测试在yml里面配置
//                    return HystrixCommand.Setter
//                            .withGroupKey(HystrixCommandGroupKey.Factory.asKey(target.name()))
//                            .andCommandPropertiesDefaults(
//                                    HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)
//                            );
//                }
                return HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(target.name()))
//                        .andCommandKey(HystrixCommandKey.Factory.asKey())
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1500)
                        );

            }
        });
    }

}
