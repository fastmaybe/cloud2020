package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.pojo.entity.Payment;
import com.fastmay.springcloud.pojo.result.CommonResult;
import com.fastmay.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: liulang
 * @Date: 2020/12/29 11:57
 */
@RestController
@RequestMapping("consumer")
public class OrderController {

    @Resource
    private IPaymentService paymentService;

    @PostMapping("add")
    public CommonResult createPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

    @GetMapping("query/{id}")
    public CommonResult queryById(@PathVariable(value = "id")Long id ){
        return paymentService.queryById(id);
    }



}
