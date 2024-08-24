package com.raj.customsapp.serviceImpl;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.raj.customsapp.model.ImporterPayment;
import com.raj.customsapp.repository.ImporterPaymentRepo;

class ImporterPaymentServiceImplTest {

    @Mock
    private ImporterPaymentRepo importerPaymentRepo;

    @InjectMocks
    private ImporterPaymentServiceImpl importerPaymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddApplication() {
        ImporterPayment payment = new ImporterPayment(1, 1001, new java.sql.Date(System.currentTimeMillis()), 5000, "Completed", "Credit Card");
        importerPaymentService.addApplication(payment);
        verify(importerPaymentRepo, times(1)).save(payment);
    }
}
