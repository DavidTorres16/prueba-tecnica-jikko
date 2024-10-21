package com.example.introduction.infraestructure.repositories.user;

import com.example.introduction.domain.models.User;
import com.example.introduction.domain.ports.out.user.UserRepositoryPort;
import com.example.introduction.infraestructure.entities.UserEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        return jpaUserRepository.save(userEntity).toDomainModel();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return jpaUserRepository.findById(id.longValue()).map(UserEntity::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll().stream()
                .map(UserEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> update(Integer id, User user) {
        if(jpaUserRepository.existsById(id.longValue())){
            UserEntity savedUserEntity = jpaUserRepository.save(UserEntity.fromDomainModel(user));
            return Optional.of(savedUserEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (jpaUserRepository.existsById(id.longValue())) {
            jpaUserRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
