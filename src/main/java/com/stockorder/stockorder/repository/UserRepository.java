package com.stockorder.stockorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockorder.stockorder.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserId(long userId);

}
