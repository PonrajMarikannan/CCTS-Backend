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

import com.raj.customsapp.model.ImporterApplication;
import com.raj.customsapp.model.ImporterInvoice;
import com.raj.customsapp.repository.ImporterInvoiceRepo;

class ImporterInvoiceServiceImplTest {

    @Mock
    private ImporterInvoiceRepo importerInvoiceRepo;

    @InjectMocks
    private ImporterInvoiceServiceImpl importerInvoiceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddApplication() {
        ImporterApplication app = new ImporterApplication();
        ImporterInvoice invoice = new ImporterInvoice(1, app, 1000, new Date(System.currentTimeMillis()));

        importerInvoiceService.addApplication(invoice);

        verify(importerInvoiceRepo, times(1)).save(invoice);
    }

    @Test
    void testGetInv() {
        ImporterApplication app = new ImporterApplication();
        ImporterInvoice invoice = new ImporterInvoice(1, app, 1000, new Date(System.currentTimeMillis()));
        
        when(importerInvoiceRepo.getInv(1)).thenReturn(invoice);

        ImporterInvoice result = importerInvoiceService.getInv(1);

        assertNotNull(result);
        assertEquals(invoice.getInvoiceId(), result.getInvoiceId());
    }

    @Test
    void testGetAllInv() {
        ImporterApplication app = new ImporterApplication();
        ImporterInvoice invoice1 = new ImporterInvoice(1, app, 1000, new Date(System.currentTimeMillis()));
        ImporterInvoice invoice2 = new ImporterInvoice(2, app, 2000, new Date(System.currentTimeMillis()));
        List<ImporterInvoice> invoices = Arrays.asList(invoice1, invoice2);
        
        when(importerInvoiceRepo.findAll()).thenReturn(invoices);

        List<ImporterInvoice> result = importerInvoiceService.getAllInv();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(invoice1));
        assertTrue(result.contains(invoice2));
    }

    @Test
    void testGetInvoicesByUserId() {
        ImporterApplication app = new ImporterApplication();
        ImporterInvoice invoice1 = new ImporterInvoice(1, app, 1000, new Date(System.currentTimeMillis()));
        ImporterInvoice invoice2 = new ImporterInvoice(2, app, 2000, new Date(System.currentTimeMillis()));
        List<ImporterInvoice> invoices = Arrays.asList(invoice1, invoice2);
        
        when(importerInvoiceRepo.getInvoicesByUserId(1)).thenReturn(invoices);

        List<ImporterInvoice> result = importerInvoiceService.getInvoicesByUserId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(invoice1));
        assertTrue(result.contains(invoice2));
    }
}
