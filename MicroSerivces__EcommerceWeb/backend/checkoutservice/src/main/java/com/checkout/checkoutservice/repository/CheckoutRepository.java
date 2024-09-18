package com.checkout.checkoutservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkout.checkoutservice.model.CheckoutModel;

public interface CheckoutRepository extends JpaRepository<CheckoutModel, Long>{

}
