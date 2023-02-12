package com.jclipboard.jclipboard.dto;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private String title;
    private String description;
    private String content;
    private UserDTO user;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expiration;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime cretedAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;
}
