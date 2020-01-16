package com.grs.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grs.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
