package com.capstone.kakaoJWT.repository;

import com.capstone.kakaoJWT.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}