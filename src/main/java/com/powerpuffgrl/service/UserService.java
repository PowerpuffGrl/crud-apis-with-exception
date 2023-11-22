package com.powerpuffgrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powerpuffgrl.dto.UserRequest;
import com.powerpuffgrl.entity.User;
import com.powerpuffgrl.exception.UserNotFoundException;
import com.powerpuffgrl.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		User user = userRepository.findByUserId(id);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("User not found with id: "+id);
		} 
				
	}
}
