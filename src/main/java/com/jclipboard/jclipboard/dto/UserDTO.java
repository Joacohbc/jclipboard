package com.jclipboard.jclipboard.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    
    // TODO: Que hago con la contraseña?
    // private String password;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;
}
