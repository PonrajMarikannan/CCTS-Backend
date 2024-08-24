package com.raj.customsapp.service;

import com.raj.customsapp.model.User;

public interface UserService {
	
    void addUser(User user);
    User findUserByEmail(String email);
	User getUser(int id); 
}
