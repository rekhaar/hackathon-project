/**
 * 
 */
package com.abc.app.mortgage.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.app.mortgage.model.User;
import com.abc.app.mortgage.service.IUserService;
import com.abc.app.mortgage.vo.UserDto;

/**
 * @author 91929
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("/userdetails/{ID}")
	public ResponseEntity<UserDto> getUserDetailsById(@RequestParam("ID") long id) {

		User user = userService.getUserDetailsById(id);

		return new ResponseEntity<UserDto>(converToUserDto(user), HttpStatus.OK);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody User user) {

		User user1 = userService.createUser(user);
		UserDto userDto=converToUserDto(user1);
		
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}

	private UserDto converToUserDto(User user){
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
		}
	
}
