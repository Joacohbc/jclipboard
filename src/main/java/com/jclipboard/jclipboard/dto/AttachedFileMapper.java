package com.jclipboard.jclipboard.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jclipboard.jclipboard.entities.AttachedFile;

@Component
public class AttachedFileMapper {
    
    @Autowired
    private ClipboardItemMapper clipboardItemMapper;

    // Mapper para pasar de DTO a Entidad
    public AttachedFileDTO toDTO(AttachedFile attachedFile) {
        return AttachedFileDTO.builder()
            .id(attachedFile.getId())
            .name(attachedFile.getName())
            .path(attachedFile.getPath())
            .size(attachedFile.getSize())
            .clipboard(clipboardItemMapper.toDTO(attachedFile.getClipboard()))
            .extension(attachedFile.getExtension())
            .cretedAt(attachedFile.getCretedAt())
            .updatedAt(attachedFile.getUpdatedAt())
            .build();
    }

    // Mapper para pasar de Entidad a DTO
    public AttachedFile toEntity(AttachedFileDTO attachedFileDTO) {
        return AttachedFile.builder()
            .id(attachedFileDTO.getId())
            .name(attachedFileDTO.getName())
            .path(attachedFileDTO.getPath())
            .size(attachedFileDTO.getSize())
            .clipboard(clipboardItemMapper.toEntity(attachedFileDTO.getClipboard()))
            .extension(attachedFileDTO.getExtension())
            .cretedAt(attachedFileDTO.getCretedAt())
            .updatedAt(attachedFileDTO.getUpdatedAt())
            .build();
    }

    // Mapper de Lista de Entidad a lista de DTO
    public List<AttachedFileDTO> toListDTO(List<AttachedFile> attachedFiles) {
        List<AttachedFileDTO> attachedFilesDTO = new ArrayList<>();
        for (AttachedFile attachedFile : attachedFiles) {
            attachedFilesDTO.add(toDTO(attachedFile));
        }
        return attachedFilesDTO;
    }
    
    // Mapper de Lista de DTO a lista de Entidad
    public List<AttachedFile> toListEntity(List<AttachedFileDTO> attachedFilesDTO) {
        List<AttachedFile> attachedFiles = new ArrayList<>();
        for (AttachedFileDTO attachedFileDTO : attachedFilesDTO) {
            attachedFiles.add(toEntity(attachedFileDTO));
        }
        return attachedFiles;
    }
}
