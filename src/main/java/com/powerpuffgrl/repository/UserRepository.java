package com.powerpuffgrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.powerpuffgrl.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(int id);
}
