/**
 * 
 */
package com.abc.app.mortgage.service;

import com.abc.app.mortgage.model.User;

/**
 * @author Rambabu Keshetti
 *
 */
public interface IUserService {
	public User getUserDetailsById(long id);

	public User createUser(User user);

}
