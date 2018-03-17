package com.project.restaurant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restaurant.models.User;
import com.project.restaurant.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> search() {
		return (List<User>) userRepository.findAll();
	}

	public List<User> save(User items) {
		userRepository.save(items);
		return (List<User>) userRepository.findAll();
	}

	public List<User> delete(User items) {
		userRepository.delete(items);
		return (List<User>) userRepository.findAll();
	}

	public List<User> deleteById(Long id) {
		userRepository.deleteById(id);
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public Iterable<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
