package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.pojo.entity.Payment;
import com.fastmay.springcloud.pojo.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: liulang
 * @Date: 2020/12/29 11:57
 */
@RestController
@RequestMapping("consumer")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://SLEUTH-PAYMENT-SERVICE";

    @PostMapping("restTemplate/add")
    public CommonResult createPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL +"/api/payment/add",payment,CommonResult.class);
    }

    @GetMapping("restTemplate/query/{id}")
    public CommonResult queryById(@PathVariable(value = "id")Long id ){
        return restTemplate.getForObject(PAYMENT_URL+"/api/payment/query/"+id,CommonResult.class);
    }



}
