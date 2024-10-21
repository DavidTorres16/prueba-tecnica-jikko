package com.example.introduction.application.usecases.user;

import com.example.introduction.domain.models.User;
import com.example.introduction.domain.ports.in.user.CreateUserUseCase;
import com.example.introduction.domain.ports.out.user.UserRepositoryPort;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;


    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.save(user);
    }
}
