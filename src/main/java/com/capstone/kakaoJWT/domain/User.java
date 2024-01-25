package com.capstone.kakaoJWT.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_table")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    String email;

    @Builder
    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}