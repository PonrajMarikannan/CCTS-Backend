package com.raj.customsapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.customsapp.model.User;
import com.raj.customsapp.repository.UserRepo;
import com.raj.customsapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo repo;
    
    public void addUser(User user) {
        repo.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return repo.findByEmail(email);
    }
    
    @Override
	public User getUser(int id) {
		return repo.findById(id);
	}
    
}
