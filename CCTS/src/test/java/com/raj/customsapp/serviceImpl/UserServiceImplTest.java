package com.raj.customsapp.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.raj.customsapp.model.User;
import com.raj.customsapp.repository.UserRepo;

class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        User user = new User(null, "nandha", "Kumar001**", "user", "nandha@gmail.com");
        userService.addUser(user);
        verify(userRepo, times(1)).save(user);
    }

    @Test
    void testFindUserByEmail() {
        User user = new User(1, "nandha", "Kumar001**", "user", "nandha@gmail.com");
        when(userRepo.findByEmail("nandha@gmail.com")).thenReturn(user);
        User foundUser = userService.findUserByEmail("nandha@gmail.com");
        assertEquals(user, foundUser);
    }

    @Test
    void testFindUserByEmailNotFound() {
        when(userRepo.findByEmail("non_existent@example.com")).thenReturn(null);
        User foundUser = userService.findUserByEmail("non_existent@example.com");
        assertNull(foundUser);
    }

    @Test
    void testGetUser() {
        User user = new User(1, "nandha", "Kumar001**", "user", "nandha@gmail.com");
        when(userRepo.findById(1)).thenReturn(user);
        User foundUser = userService.getUser(1);
        assertEquals(user, foundUser);
    }

    @Test
    void testGetUserNotFound() {
        when(userRepo.findById(1)).thenReturn(null);
        User foundUser = userService.getUser(1);
        assertNull(foundUser);
    }
}
