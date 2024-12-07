package com.abc.app.mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.app.mortgage.entity.Account;
import com.abc.app.mortgage.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByUserName(String userName);
}