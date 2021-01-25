package com.fastmay.springcloud.service;

import com.fastmay.springcloud.pojo.entity.Payment;
import com.fastmay.springcloud.pojo.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: liulang
 * @Date: 2020/12/30 14:10
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface IPaymentService {


    @PostMapping("api/payment/add")
    CommonResult createPayment(@RequestBody Payment payment);


    @GetMapping("api/payment/query/{id}")
     CommonResult queryById(@PathVariable(value = "id") Long id);



}
