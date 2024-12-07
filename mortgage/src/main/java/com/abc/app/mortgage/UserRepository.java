package com.abc.app.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.app.mortgage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
