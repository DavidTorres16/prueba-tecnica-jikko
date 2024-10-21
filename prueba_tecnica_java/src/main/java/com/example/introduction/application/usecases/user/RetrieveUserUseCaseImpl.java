package com.example.introduction.application.usecases.user;

import com.example.introduction.domain.models.User;
import com.example.introduction.domain.ports.in.user.RetrieveUserUseCase;
import com.example.introduction.domain.ports.out.user.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUserUseCaseImpl implements RetrieveUserUseCase {

    private final UserRepositoryPort userRepositoryPort;


    public RetrieveUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.findAll();
    }
}
