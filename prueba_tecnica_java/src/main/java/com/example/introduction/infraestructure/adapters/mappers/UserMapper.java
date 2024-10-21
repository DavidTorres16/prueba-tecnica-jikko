package com.example.introduction.infraestructure.adapters.mappers;

import com.example.introduction.domain.models.User;
import com.example.introduction.infraestructure.controllers.dto.in.UserDTO;
import com.example.introduction.infraestructure.controllers.dto.in.UserUpdateDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toUserCreationDTO(User user) {
        if (user == null) {
            return null;
        }

        return new UserDTO(
                user.getAge(),
                user.getName(),
                user.getLastName(),
                user.getPersonalId()
        );
    }


    public static User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return new User(
                null,
                userDTO.getAge(),
                userDTO.getName(),
                userDTO.getLastName(),
                userDTO.getPersonalId(),
                null
        );
    }

    public static User toUser(UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO == null) {
            return null;
        }

        return new User(
                userUpdateDTO.getId(),
                userUpdateDTO.getAge(),
                userUpdateDTO.getName(),
                userUpdateDTO.getLastName(),
                userUpdateDTO.getPersonalId(),
                null
        );
    }


    public static List<UserDTO> toUserCreationDTOList(List<User> users) {
        if (users == null) {
            return null;
        }

        return users.stream()
                .map(UserMapper::toUserCreationDTO)
                .collect(Collectors.toList());
    }


    public static List<User> toUserList(List<UserDTO> userDTOS) {
        if (userDTOS == null) {
            return null;
        }

        return userDTOS.stream()
                .map(UserMapper::toUser)
                .collect(Collectors.toList());
    }
}
