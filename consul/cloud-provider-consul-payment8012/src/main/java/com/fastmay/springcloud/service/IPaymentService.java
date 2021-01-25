package com.fastmay.springcloud.service;

import com.fastmay.springcloud.pojo.entity.Payment;

/**
 * @Author: liulang
 * @Date: 2020/12/28 17:05
 */
public interface IPaymentService {

    int createPayment(Payment payment);

    Payment findPaymentById(Long id);
}
