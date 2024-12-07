/**
 * 
 */
package com.abc.app.mortgage;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.abc.app.mortgage.model.User;
import com.abc.app.mortgage.repository.UserRepository;
import com.abc.app.mortgage.service.UserService;

/**
 * @author 91929
 *
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	/**
	 * 
	 */
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	@Test 
	public void testCreateUser() {
		
		
		User user1=new User();
		user1.setUserid(1l);
		user1.setActive(true);
		user1.setAddressLine("hyderabad");
	//	user1.setBirthDate(new Date("22-02-2000"));
		user1.setCountry("India");
		user1.setCreateDate(LocalDateTime.now());
		user1.setUpdateDate(LocalDateTime.now());
		user1.setUpdatedBy(1111l);
		user1.setCreatedBy(2222l);
		user1.setEmailId("rambabu.keshetti@rediffmail.com");
		user1.setPostalcode("500085");
		user1.setPrimaryMobileNo("9999999999");
		user1.setSecondaryMobileNo("77777777777");
		
		when(userRepository.save(user1)).thenReturn(user1);
		
		User user2=userService.createUser(user1);
		Assert.assertEquals(user1.getUserid(),user2.getUserid());
		
	}
	
	
	
}
