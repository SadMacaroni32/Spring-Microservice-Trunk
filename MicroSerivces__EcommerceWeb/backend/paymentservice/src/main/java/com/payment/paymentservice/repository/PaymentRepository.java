package com.payment.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.paymentservice.model.PaymentModel;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {

    
}
