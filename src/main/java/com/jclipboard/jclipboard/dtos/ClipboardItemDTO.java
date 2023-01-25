package com.jclipboard.jclipboard.dtos;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jclipboard.jclipboard.entities.AttachedFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClipboardItemDTO {
    private Long id;
    private String text;
    private List<AttachedFile> attachedFiles;
    private UserDTO user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date expiration;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cretedAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
