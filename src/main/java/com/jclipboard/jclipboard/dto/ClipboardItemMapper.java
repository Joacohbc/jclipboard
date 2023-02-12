package com.jclipboard.jclipboard.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jclipboard.jclipboard.entities.ClipboardItem;

@Component
public class ClipboardItemMapper {
    
    
    @Autowired
    private UserMapper userMapper;

    // Mapper para pasar de DTO a Entidad
    public ClipboardItemDTO toDTO(ClipboardItem clipboardItem) {
        return ClipboardItemDTO.builder()
            .id(clipboardItem.getId())
            .title(clipboardItem.getTitle())
            .description(clipboardItem.getDescription())
            .content(clipboardItem.getContent())
            .user(userMapper.toDTO(clipboardItem.getUser()))
            .expiration(clipboardItem.getExpiration())
            .cretedAt(clipboardItem.getCretedAt())
            .updatedAt(clipboardItem.getUpdatedAt())
            .build();
    }

    // Mapper para pasar de Entidad a DTO
    public ClipboardItem toEntity(ClipboardItemDTO clipboardItemDTO) {
        return ClipboardItem.builder()
            .id(clipboardItemDTO.getId())
            .title(clipboardItemDTO.getTitle())
            .description(clipboardItemDTO.getDescription())
            .content(clipboardItemDTO.getContent())
            .user(userMapper.toEntity(clipboardItemDTO.getUser()))
            .expiration(clipboardItemDTO.getExpiration())
            .cretedAt(clipboardItemDTO.getCretedAt())
            .updatedAt(clipboardItemDTO.getUpdatedAt())
            .build();
    }

    // Mapper de Lista de Entidad a lista de DTO
    public List<ClipboardItemDTO> toListDTO(List<ClipboardItem> clipboardItems) {
        List<ClipboardItemDTO> clipboardItemsDTO = new ArrayList<>();
        for (ClipboardItem clipboardItem : clipboardItems) {
            clipboardItemsDTO.add(toDTO(clipboardItem));
        }
        return clipboardItemsDTO;
    }

    // Mapper de Lista de DTO a lista de Entidad
    public List<ClipboardItem> toListEntity(List<ClipboardItemDTO> clipboardItemsDTO) {
        List<ClipboardItem> clipboardItems = new ArrayList<>();
        for (ClipboardItemDTO clipboardItemDTO : clipboardItemsDTO) {
            clipboardItems.add(toEntity(clipboardItemDTO));
        }
        return clipboardItems;
    }
    
}
