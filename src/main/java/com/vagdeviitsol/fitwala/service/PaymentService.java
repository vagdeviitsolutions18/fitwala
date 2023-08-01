package com.vagdeviitsol.fitwala.service;

import java.util.Optional;

import com.vagdeviitsol.fitwala.model.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);

    Optional<Payment> getPaymentById(Long paymentId);

    Payment updatePayment( Long paymentId,Payment payment);

    void deletePayment(Long paymentId);
}



