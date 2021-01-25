package com.fastmay.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liulang
 * @Date: 2020/12/30 11:24
 */
@Configuration
public class DyRule {


    /**
     * 或者 直接在yml里面配置
     * @return
     */
    @Bean
    public IRule myRule(){
        //随机
        return new RoundRobinRule();
    }
}
