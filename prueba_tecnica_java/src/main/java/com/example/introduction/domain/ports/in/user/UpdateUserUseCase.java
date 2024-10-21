package com.example.introduction.domain.ports.in.user;

import com.example.introduction.domain.models.User;

import java.util.Optional;

public interface UpdateUserUseCase {

    Optional<User> updateUser(Integer id, User user);

}
