package com.example.introduction.domain.ports.out.user;

import com.example.introduction.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(Integer id);

    List<User> findAll();

    Optional<User> update(Integer id, User user);

    Boolean deleteById(Integer id);

}
