package com.fastmay.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: liulang
 * @Date: 2021/1/8 15:23
 */
@Component
public class PaymentHystrixServiceFallBack implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut fallback";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "paymentCircuitBreaker fall back";
    }
}
