package com.jclipboard.jclipboard.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jclipboard.jclipboard.entities.User;


@Component
public class UserMapper {
    
    // Mapper para pasar de DTO a Entidad
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .createdAt(user.getCreatedAt())
            .updatedAt(user.getUpdatedAt())
            .build();
    }

    // Mapper para pasar de Entidad a DTO
    public User toEntity(UserDTO userDTO) {
        return User.builder()
            .id(userDTO.getId())
            .username(userDTO.getUsername())
            .email(userDTO.getEmail())
            .createdAt(userDTO.getCreatedAt())
            .updatedAt(userDTO.getUpdatedAt())
            .build();
    }

    // Mapper de Lista de Entidad a lista de DTO
    public List<UserDTO> toListDTO(List<User> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(toDTO(user));
        }
        return usersDTO;
    }

    // Mapper de Lista de DTO a lista de Entidad
    public List<User> toListEntity(List<UserDTO> usersDTO) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : usersDTO) {
            users.add(toEntity(userDTO));
        }
        return users;
    }
    
}
