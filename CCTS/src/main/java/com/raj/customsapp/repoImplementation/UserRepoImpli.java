package com.raj.customsapp.repoImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.raj.customsapp.model.User;
import com.raj.customsapp.repository.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepoImpli implements UserRepo {

	@Autowired
	EntityManager eManager;
	
	public void save(User user) {
		eManager.persist(user);
	}
	
	@Override
    public User findByEmail(String email) {
        String hql = "FROM User WHERE email = :email";
        TypedQuery<User> query = eManager.createQuery(hql, User.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        }
	}
	
	public User findById(int id) {
		return eManager.find(User.class, id);
	}

}
	


