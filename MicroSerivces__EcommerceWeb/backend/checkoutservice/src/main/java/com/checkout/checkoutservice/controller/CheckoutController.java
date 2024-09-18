package com.checkout.checkoutservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkout.checkoutservice.model.CheckoutModel;
import com.checkout.checkoutservice.service.CheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/process")
    public CheckoutModel processCheckout(@RequestBody CheckoutModel checkout) {
        return checkoutService.processCheckout(checkout);
    }

}
