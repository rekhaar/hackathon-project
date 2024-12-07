/**
 * 
 */
package com.abc.app.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.app.mortgage.exception.UserNotFoundException;
import com.abc.app.mortgage.model.User;
import com.abc.app.mortgage.repository.UserRepository;

/**
 * @author 91929
 *
 */
@Service
public class UserService implements IUserService {

	/**
	 * 
	 */
	@Autowired
	UserRepository userRepository;
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getUserDetailsById(long id) {
		if(!userRepository.existsById(id)) {
			throw new UserNotFoundException("user not available with "+id);
		}
		
		return userRepository.findById(id).get();
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	
}
