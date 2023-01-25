package com.jclipboard.jclipboard.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.jclipboard.jclipboard.dtos.UserDTO;
import com.jclipboard.jclipboard.entities.User;

public class UserMapper {
    

    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public List<User> toEntityList(List<UserDTO> userDTOList) {
        return userDTOList.stream().map(userDTO -> toEntity(userDTO)).collect(Collectors.toList());
    }

    public List<UserDTO> toDTOList(List<User> userList) {
        return userList.stream().map(user -> toDTO(user)).collect(Collectors.toList());
    }
    
}
