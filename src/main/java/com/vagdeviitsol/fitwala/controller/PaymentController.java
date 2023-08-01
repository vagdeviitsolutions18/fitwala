package com.vagdeviitsol.fitwala.controller;

import com.vagdeviitsol.fitwala.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vagdeviitsol.fitwala.model.Payment;
import com.vagdeviitsol.fitwala.repository.PaymentRepository;
import com.vagdeviitsol.fitwala.service.PaymentServiceImpll;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/v1/fitwala/payment")
    public Payment createPayment(@RequestBody Payment payment) {

        return service.createPayment(payment);
    }

    @GetMapping("/v1/fitwala/payment/{paymentId}")
    public Payment getPayment(@PathVariable Long paymentId) {
        return service.getPaymentById(paymentId).orElse(null);
    }

    @PutMapping("/v1/fitwala/payment/update/{paymentId}")
    public Payment updatePayment(@PathVariable Long paymentId, @RequestBody Payment updatedPayment) {

            return service.updatePayment(paymentId,updatedPayment);

    }

    @DeleteMapping("/v1/fitwala/payment/delete/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId) {
        service.deletePayment(paymentId);
    }
}


