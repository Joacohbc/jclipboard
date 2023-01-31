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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachedFileDTO implements Serializable {
    private Long id;
    private String name;
    private String path;
    private String size;
    private ClipboardItemDTO clipboard;
    private String extension;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime cretedAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;
}
