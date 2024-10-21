package com.example.introduction.infraestructure.repositories.user;

import com.example.introduction.infraestructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
