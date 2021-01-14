package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService{
	 @Autowired private UserRepository userRepository;  

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();  
	}

	@Override
	public void saveUser(User user) {
		 userRepository.save(user);  
		
	}

	@Override
	public void deleteUser(Integer id) {
		 userRepository.deleteById(id);  
		
	}

	@Override
	public Optional<User> findUserById(Integer id) {
		 return userRepository.findById(id);  
	}

}
