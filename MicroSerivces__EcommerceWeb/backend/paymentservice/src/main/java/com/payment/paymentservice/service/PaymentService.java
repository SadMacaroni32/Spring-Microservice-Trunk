package com.payment.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.paymentservice.model.PaymentModel;
import com.payment.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {

     @Autowired
    private PaymentRepository paymentRepository;

    public PaymentModel processPayment(PaymentModel payment) {
        payment.setStatus("COMPLETED");
        return paymentRepository.save(payment);
    }

}
