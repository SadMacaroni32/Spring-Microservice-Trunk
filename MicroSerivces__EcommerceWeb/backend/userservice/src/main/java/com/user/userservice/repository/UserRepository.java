package com.user.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
