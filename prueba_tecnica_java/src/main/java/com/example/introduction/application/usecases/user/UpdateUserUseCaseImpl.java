package com.example.introduction.application.usecases.user;

import com.example.introduction.domain.models.User;
import com.example.introduction.domain.ports.in.user.UpdateUserUseCase;
import com.example.introduction.domain.ports.out.user.UserRepositoryPort;

import java.util.Optional;

public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UpdateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> updateUser(Integer id, User user) {
        return userRepositoryPort.update(id, user);
    }
}
