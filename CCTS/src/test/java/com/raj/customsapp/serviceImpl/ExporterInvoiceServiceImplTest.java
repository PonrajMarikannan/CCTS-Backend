package com.raj.customsapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.raj.customsapp.model.ExporterInvoice;
import com.raj.customsapp.repository.ExporterInvoiceRepo;

class ExporterInvoiceServiceImplTest {

    @Mock
    private ExporterInvoiceRepo exporterInvoiceRepo;

    @InjectMocks
    private ExporterInvoiceServiceImpl exporterInvoiceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddApplication() {
        ExporterInvoice invoice = new ExporterInvoice();
        invoice.setInvoiceId(1);
        invoice.setAmount(1000);
        invoice.setInvoiceDate(new Date(System.currentTimeMillis()));
        
        exporterInvoiceService.addApplication(invoice);

        verify(exporterInvoiceRepo, times(1)).save(invoice);
    }

    @Test
    void testGetInv() {
        ExporterInvoice invoice = new ExporterInvoice();
        invoice.setInvoiceId(1);
        when(exporterInvoiceRepo.getInv(1)).thenReturn(invoice);

        ExporterInvoice result = exporterInvoiceService.getInv(1);

        assertNotNull(result);
        assertEquals(invoice, result);
    }

    @Test
    void testGetAllInv() {
        ExporterInvoice invoice1 = new ExporterInvoice();
        ExporterInvoice invoice2 = new ExporterInvoice();
        List<ExporterInvoice> invoices = Arrays.asList(invoice1, invoice2);
        when(exporterInvoiceRepo.findAll()).thenReturn(invoices);

        List<ExporterInvoice> result = exporterInvoiceService.getAllInv();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(invoice1));
        assertTrue(result.contains(invoice2));
    }

    @Test
    void testGetInvoicesByUserId() {
        ExporterInvoice invoice1 = new ExporterInvoice();
        ExporterInvoice invoice2 = new ExporterInvoice();
        List<ExporterInvoice> invoices = Arrays.asList(invoice1, invoice2);
        when(exporterInvoiceRepo.getInvoicesByUserId(1)).thenReturn(invoices);

        List<ExporterInvoice> result = exporterInvoiceService.getInvoicesByUserId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(invoice1));
        assertTrue(result.contains(invoice2));
    }
}
