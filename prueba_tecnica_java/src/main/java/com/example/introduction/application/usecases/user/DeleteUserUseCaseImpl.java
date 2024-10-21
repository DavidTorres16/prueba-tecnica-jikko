package com.example.introduction.application.usecases.user;

import com.example.introduction.domain.ports.in.user.DeleteUserUseCase;
import com.example.introduction.domain.ports.out.user.UserRepositoryPort;

public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;


    public DeleteUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userRepositoryPort.deleteById(id);
    }
}
