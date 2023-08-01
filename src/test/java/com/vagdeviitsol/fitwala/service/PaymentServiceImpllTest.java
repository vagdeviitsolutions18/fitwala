package com.vagdeviitsol.fitwala.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.vagdeviitsol.fitwala.model.Payment;
import com.vagdeviitsol.fitwala.repository.PaymentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class PaymentServiceImpllTest {

    @Mock
    private PaymentRepository paymentRepositoryMock;

    @InjectMocks
    private PaymentServiceImpll paymentService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentService).build();
    }

    @Test
    public void testCreatePayment() throws Exception {

        Payment payment = new Payment();
        payment.setUserId(1L);
        payment.setAmount(100.0);
        payment.setPlanType(6);
        payment.setStatus("Paid");

        when(paymentRepositoryMock.save(any(Payment.class))).thenReturn(payment);

        mockMvc.perform(post("/v1/fitwala/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1,\"amount\":100,\"planType\":6,\"status\":\"Paid\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.amount").value(100.0))
                .andExpect(jsonPath("$.planType").value(6))
                .andExpect(jsonPath("$.status").value("Paid"));
    }
}