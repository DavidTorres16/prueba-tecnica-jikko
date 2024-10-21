package com.example.introduction.domain.ports.in.user;

import com.example.introduction.domain.models.User;

public interface CreateUserUseCase {

    User createUser(User user);

}
