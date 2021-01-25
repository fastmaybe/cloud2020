package com.fastmay.springcloud.controller;

import com.fastmay.springcloud.pojo.entity.Payment;
import com.fastmay.springcloud.pojo.result.CommonResult;
import com.fastmay.springcloud.pojo.result.DYCode;
import com.fastmay.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: liulang
 * @Date: 2020/12/28 17:12
 */
@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;


    @PostMapping("add")
    public CommonResult createPayment(@RequestBody Payment payment){
        int res = paymentService.createPayment(payment);
        if (res > 0) return DYCode.SUCCESS.result("添加成功");
        return DYCode.ERROR.result("添加失败");
    }

    @GetMapping("query/{id}")
    public CommonResult queryById(@PathVariable(value = "id")Long id ){
        Payment payment = paymentService.findPaymentById(id);
        return DYCode.SUCCESS.result(payment,"成功-【8011提供服务】");
    }

}
