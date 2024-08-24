package com.raj.customsapp.serviceImpl;

import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.raj.customsapp.model.ExporterPayment;
import com.raj.customsapp.repository.ExporterPaymentRepo;

class ExporterPaymentServiceImplTest {

    @Mock
    private ExporterPaymentRepo exporterPaymentRepo;

    @InjectMocks
    private ExporterPaymentServiceImpl exporterPaymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddApplication() {
        
        ExporterPayment payment = new ExporterPayment();
        payment.setPaymentId(1);
        payment.setExpInvoiceId(1001);
        payment.setPaymentDate(new Date(System.currentTimeMillis()));
        payment.setAmountPaid(500);
        payment.setPaymentStatus("Completed");
        payment.setPaymentMethod("Credit Card");

     
        exporterPaymentService.addApplication(payment);

        
        verify(exporterPaymentRepo, times(1)).save(payment);
    }
}
