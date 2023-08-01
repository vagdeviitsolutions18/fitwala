package com.vagdeviitsol.fitwala.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vagdeviitsol.fitwala.model.Payment;
import com.vagdeviitsol.fitwala.repository.PaymentRepository;
import com.vagdeviitsol.fitwala.service.PaymentServiceImpll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class PaymentControllerTest {

    @Mock
    private PaymentServiceImpll paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentController paymentController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void testCreatePayment() throws Exception {
        Payment payment = new Payment();
        payment.setUserId(1L);
        payment.setAmount(100.0);
        payment.setPlanType(6);
        payment.setStatus("Paid");

        // Mock the behavior of the PaymentServiceImpl
        when(paymentService.createPayment(any(Payment.class))).thenReturn(payment);

        // Perform the POST request with the JSON payload
        mockMvc.perform(post("/v1/fitwala/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":2,\"amount\":100,\"planType\":6,\"status\":\"paid\"}"))// Convert Payment object to JSON
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.amount").value(100.0))
                .andExpect(jsonPath("$.planType").value(6))
                .andExpect(jsonPath("$.status").value("Paid"));

    }
    }





























