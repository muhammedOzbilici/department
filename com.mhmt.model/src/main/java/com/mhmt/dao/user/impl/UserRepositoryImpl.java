package com.mhmt.dao.user.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mhmt.dao.user.UserRepository;
import com.mhmt.domain.user.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User saveUser(User user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = entityManager.merge(user);
		return updatedUser;
	}

	@Override
	public User deleteUser(User user) {
		if (entityManager.contains(user)) {
			entityManager.remove(user);
			return user;
		}
		User deleteUser = findUserById(user.getId());
		entityManager.remove(deleteUser);
		return deleteUser;
	}

	@Override
	public User findUserById(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User findUserByEmail(String email) {
		return entityManager.createNamedQuery("User.findByEmail", User.class)
				.setParameter("email", email)
				.getSingleResult();
	}

	@Override
	public User findUserByUsername(String username) {
		return entityManager.createNamedQuery("User.findByUsername", User.class)
				.setParameter("username", username)
				.getSingleResult();
				
	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createNamedQuery("User.findAll",User.class).getResultList();
	}

}
