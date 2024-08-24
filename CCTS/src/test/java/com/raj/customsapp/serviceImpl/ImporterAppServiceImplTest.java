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

import com.raj.customsapp.repository.ImporterAppRepo;

class ImporterAppServiceImplTest {

    @Mock
    private ImporterAppRepo importerAppRepo;

    @InjectMocks
    private ImporterAppServiceImpl importerAppService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddApplication() {
        ImporterApplication app = new ImporterApplication();
        app.setApplicationId(1);
        app.setImporterName("John Doe");
        app.setSubmissionDate(new Date(System.currentTimeMillis()));

        importerAppService.addApplication(app);

        verify(importerAppRepo, times(1)).save(app);
    }

    @Test
    void testGetAllApp() {
        ImporterApplication app1 = new ImporterApplication();
        app1.setApplicationId(1);
        app1.setImporterName("John Doe");

        ImporterApplication app2 = new ImporterApplication();
        app2.setApplicationId(2);
        app2.setImporterName("Jane Doe");

        List<ImporterApplication> apps = Arrays.asList(app1, app2);

        when(importerAppRepo.findAll()).thenReturn(apps);

        List<ImporterApplication> result = importerAppService.getAllApp();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(app1));
        assertTrue(result.contains(app2));
    }

    @Test
    void testUpdateApp() {
        ImporterApplication app = new ImporterApplication();
        app.setApplicationId(1);
        app.setImporterName("John Doe");

        importerAppService.updateApp(app);

        verify(importerAppRepo, times(1)).update(app);
    }

    @Test
    void testGetApp() {
        ImporterApplication app = new ImporterApplication();
        app.setApplicationId(1);
        app.setImporterName("John Doe");

        when(importerAppRepo.getApp(1)).thenReturn(app);

        ImporterApplication result = importerAppService.getApp(1);

        assertNotNull(result);
        assertEquals(1, result.getApplicationId());
        assertEquals("John Doe", result.getImporterName());
    }
}
