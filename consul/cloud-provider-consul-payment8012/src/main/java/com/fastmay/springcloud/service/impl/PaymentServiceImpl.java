package com.fastmay.springcloud.service.impl;

import com.fastmay.springcloud.dao.PaymentMapper;
import com.fastmay.springcloud.pojo.entity.Payment;

import com.fastmay.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @Author: liulang
 * @Date: 2020/12/28 17:06
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int createPayment(Payment payment) {
       return paymentMapper.insert(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
      return  paymentMapper.selectByPrimaryKey(id);
    }
}
