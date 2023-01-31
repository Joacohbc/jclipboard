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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClipboardItemDTO implements Serializable {
    private Long id;
    private String text;
    private UserDTO user;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date expiration;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date cretedAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updatedAt;
}
