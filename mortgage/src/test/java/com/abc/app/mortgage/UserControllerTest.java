/**
 * 
 */
package com.abc.app.mortgage;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.abc.app.mortgage.model.User;
import com.abc.app.mortgage.repository.UserRepository;
import com.abc.app.mortgage.vo.UserDto;

/**
 * @author 91929
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "spring.jpa.hibernate.ddl-auto=create-drop" })
public class UserControllerTest {

	@LocalServerPort
	private Integer port;
	private String baseUri = "http://localhost:";

	@Autowired
	UserRepository userRepository;

	@Autowired
	TestRestTemplate restTemplate;

	@BeforeEach
	void testSetUp() {
		baseUri = "http://localhost:" + port;
		User user1 = new User();
		user1.setUserid(1l);
		user1.setActive(true);
		user1.setAddressLine("hyderabad");
		// user1.setBirthDate(new Date("22-02-2000"));
		user1.setCountry("India");
		user1.setCreateDate(LocalDateTime.now());
		user1.setUpdateDate(LocalDateTime.now());
		user1.setUpdatedBy(1111l);
		user1.setCreatedBy(2222l);
		user1.setEmailId("rambabu.keshetti@rediffmail.com");
		user1.setPostalcode("500085");
		user1.setPrimaryMobileNo("9999999999");
		user1.setSecondaryMobileNo("77777777777");

		User user2 = new User();
		user2.setActive(true);
		user2.setAddressLine("hyderabad");
		// user2.setBirthDate(new Date("22-02-2000"));
		user2.setCountry("India");
		user2.setCreateDate(LocalDateTime.now());
		user2.setUpdateDate(LocalDateTime.now());
		user2.setUpdatedBy(1111l);
		user2.setCreatedBy(2222l);
		user2.setEmailId("rambabu.keshetti@rediffmail.com");
		user2.setPostalcode("500085");
		user2.setPrimaryMobileNo("9999999999");
		user2.setSecondaryMobileNo("77777777777");

		userRepository.saveAll(List.of(user1, user2));

	}

	@Test
	public void testCreateUser() {
		User user3 = new User();
		user3.setUserid(3l);
		user3.setActive(true);
		user3.setAddressLine("hyderabad");
		// user3.setBirthDate(new Date("22-02-2000"));
		user3.setCountry("India");
		user3.setCreateDate(LocalDateTime.now());
		user3.setUpdateDate(LocalDateTime.now());
		user3.setUpdatedBy(1111l);
		user3.setCreatedBy(2222l);
		user3.setEmailId("rambabu.keshetti@rediffmail.com");
		user3.setPostalcode("500085");
		user3.setPrimaryMobileNo("9999999999");
		user3.setSecondaryMobileNo("77777777777");
		HttpEntity<?> httpEntity = new HttpEntity<>(user3);

		ParameterizedTypeReference<UserDto> typeRef = new ParameterizedTypeReference<>() {
		};

		ParameterizedTypeReference<User> typeRef1 = new ParameterizedTypeReference<>() {
		};
		ResponseEntity<UserDto> response = restTemplate.exchange(baseUri + "/user/createUser", HttpMethod.POST,

				httpEntity, typeRef, typeRef1, null);

		// test response code
		assertEquals(HttpStatus.OK, response.getStatusCode());

		UserDto user4 = response.getBody();

		assertEquals(3, user4.getUserid());

	}

	/**
	 * 
	 *//*
		 * @Test public void testGetUserDetailsById() {
		 * 
		 * String Id = "3l"; ParameterizedTypeReference<UserDto> typeRef = new
		 * ParameterizedTypeReference<>() { };
		 * 
		 * ResponseEntity<UserDto> response = restTemplate.exchange(baseUri +
		 * "/user/userdetails/" + Id, HttpMethod.GET, null, typeRef);
		 * 
		 * // test response code assertNotEquals(HttpStatus.OK,
		 * response.getStatusCode());
		 * 
		 * // UserDto user1 = response.getBody();
		 * 
		 * // assertEquals(1, user1.getUserid());
		 * 
		 * }
		 * 
		 */

}
