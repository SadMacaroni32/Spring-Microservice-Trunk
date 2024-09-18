package com.checkout.checkoutservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkout.checkoutservice.model.CheckoutModel;
import com.checkout.checkoutservice.repository.CheckoutRepository;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    public CheckoutModel processCheckout(CheckoutModel checkout) {
        checkout.setTotalPrice(checkout.getQuantity() * getProductPrice(checkout.getProductId()));
        checkout.setStatus("COMPLETED");
        return checkoutRepository.save(checkout);
    }

    private Double getProductPrice(Long productId) {
        return 100.0;
    }

}
