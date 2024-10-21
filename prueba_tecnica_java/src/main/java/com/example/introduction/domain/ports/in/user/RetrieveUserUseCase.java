package com.example.introduction.domain.ports.in.user;

import com.example.introduction.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {

    Optional<User> getUser(Integer id);

    List<User> getAllUsers();

}
