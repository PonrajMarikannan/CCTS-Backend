package com.raj.customsapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.raj.customsapp.model.ExporterApplication;
import com.raj.customsapp.repository.ExporterAppRepo;

class ExporterAppServiceImplTest {

    @Mock
    private ExporterAppRepo exporterAppRepo;

    @InjectMocks
    private ExporterAppServiceImpl exporterAppService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddApplication() {
        ExporterApplication app = new ExporterApplication();
        app.setApplicationId(1);
        app.setExporterName("Exporter Name");
        exporterAppService.addApplication(app);
        verify(exporterAppRepo, times(1)).save(app);
    }

    @Test
    void testGetAllApp() {
        ExporterApplication app1 = new ExporterApplication();
        ExporterApplication app2 = new ExporterApplication();
        List<ExporterApplication> apps = Arrays.asList(app1, app2);
        when(exporterAppRepo.findAll()).thenReturn(apps);
        List<ExporterApplication> result = exporterAppService.getAllApp();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(app1));
        assertTrue(result.contains(app2));
    }

    @Test
    void testUpdateApp() {
        ExporterApplication app = new ExporterApplication();
        app.setApplicationId(1);
        exporterAppService.updateApp(app);
        verify(exporterAppRepo, times(1)).update(app);
    }

    @Test
    void testGetApp() {
        ExporterApplication app = new ExporterApplication();
        app.setApplicationId(1);
        when(exporterAppRepo.getApp(1)).thenReturn(app);
        ExporterApplication result = exporterAppService.getApp(1);
        assertNotNull(result);
        assertEquals(app, result);
    }

    @Test
    void testGetAllAppInt() {
        ExporterApplication app1 = new ExporterApplication();
        ExporterApplication app2 = new ExporterApplication();
        List<ExporterApplication> apps = Arrays.asList(app1, app2);
        when(exporterAppRepo.findShipStatus(1)).thenReturn(apps);
        List<ExporterApplication> result = exporterAppService.getAllApp(1);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(app1));
        assertTrue(result.contains(app2));
    }
}
