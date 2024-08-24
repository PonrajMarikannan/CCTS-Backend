package com.raj.customsapp.repository;

import com.raj.customsapp.model.User;

public interface UserRepo {
	
    void save(User user);
    User findByEmail(String email);
	User findById(int id);
}

