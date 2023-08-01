package com.vagdeviitsol.fitwala.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vagdeviitsol.fitwala.model.Payment;
import com.vagdeviitsol.fitwala.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpll implements PaymentService{

	@Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public Payment updatePayment( Long paymentId,Payment payment) {
        Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);
        if (existingPayment != null) {
            existingPayment.setUserId(payment.getUserId());
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPlanType(payment.getPlanType());
            existingPayment.setStatus(payment.getStatus());
            return paymentRepository.save(existingPayment);
        } else {
            return null;
        }
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

}


