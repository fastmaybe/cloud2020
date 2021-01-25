package com.fastmay.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liulang
 * @Date: 2020/12/30 11:24
 */
@Configuration
public class DyRule {


    @Bean
    public IRule myRule(){
        //随机
        return new RandomRule();
    }
}
