package com.raj.customsapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.raj.customsapp.model.Ship;
import com.raj.customsapp.repository.ShipRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ShipServiceImplTest {

    @Mock
    private ShipRepo shipRepo;

    @InjectMocks
    private ShipServiceImpl shipService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddShip() {
        Ship ship = new Ship(1, "Cargo Ship", 50000.0, "Arrived", new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),"Port A", "Port B", 10000.0, 5000.0);
        shipService.addShip(ship);
        verify(shipRepo, times(1)).save(ship);
    }

    @Test
    void testGetAllShips() {
        
        Ship ship1 = new Ship(1, "Cargo Ship", 50000.0, "Arrived", new Date(System.currentTimeMillis()), 
                               new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 
                               "Port A", "Port B", 10000.0, 5000.0);
        Ship ship2 = new Ship(2, "Tanker Ship", 60000.0, "Departed", new Date(System.currentTimeMillis()), 
                               new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 
                               "Port C", "Port D", 15000.0, 8000.0);
        List<Ship> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        
        when(shipRepo.findAll()).thenReturn(ships);
        
        List<Ship> result = shipService.getAllShips();
        
        assertEquals(2, result.size());
        assertTrue(result.contains(ship1));
        assertTrue(result.contains(ship2));
    }

    @Test
    void testDeleteShip() {
        int shipId = 1;
       shipService.deleteShip(shipId);
        verify(shipRepo, times(1)).delete(shipId);
    }

    @Test
    void testUpdateShip() {
       
        Ship ship = new Ship(1, "Cargo Ship", 50000.0, "Arrived", new Date(System.currentTimeMillis()), 
                              new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 
                              "Port A", "Port B", 10000.0, 5000.0);
        
        shipService.updateShip(ship);
        verify(shipRepo, times(1)).update(ship);
    }

    @Test
    void testGetShip() {
        
        Ship ship = new Ship(1, "Cargo Ship", 50000.0, "Arrived", new Date(System.currentTimeMillis()), 
                              new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 
                              "Port A", "Port B", 10000.0, 5000.0);
        
        when(shipRepo.getShip(1)).thenReturn(ship);
        Ship result = shipService.getShip(1);
        assertEquals(ship, result);
    }
}
