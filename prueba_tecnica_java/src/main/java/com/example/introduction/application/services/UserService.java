package com.example.introduction.application.services;

import com.example.introduction.domain.models.User;
import com.example.introduction.domain.ports.in.user.CreateUserUseCase;
import com.example.introduction.domain.ports.in.user.DeleteUserUseCase;
import com.example.introduction.domain.ports.in.user.RetrieveUserUseCase;
import com.example.introduction.domain.ports.in.user.UpdateUserUseCase;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

public class UserService implements CreateUserUseCase, DeleteUserUseCase, RetrieveUserUseCase, UpdateUserUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;


    public UserService(CreateUserUseCase createUserUseCase, RetrieveUserUseCase retrieveUserUseCase, DeleteUserUseCase deleteUserUseCase, UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return deleteUserUseCase.deleteUserById(id);
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return retrieveUserUseCase.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }

    @Override
    public Optional<User> updateUser(Integer id, User user) {
        return updateUserUseCase.updateUser(id, user);
    }
}
