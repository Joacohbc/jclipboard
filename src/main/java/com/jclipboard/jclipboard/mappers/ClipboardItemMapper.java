package com.jclipboard.jclipboard.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jclipboard.jclipboard.dtos.ClipboardItemDTO;
import com.jclipboard.jclipboard.entities.ClipboardItem;

@Component
public class ClipboardItemMapper {
    
    public ClipboardItemDTO toDTO(ClipboardItem clipboardItem) {
        ClipboardItemDTO dto = new ClipboardItemDTO();
        dto.setId(clipboardItem.getId());
        dto.setText(clipboardItem.getText());
        dto.setAttachedFiles(clipboardItem.getAttachedFiles());
        dto.setExpiration(clipboardItem.getExpiration());
        dto.setCretedAt(clipboardItem.getCretedAt());
        dto.setUpdatedAt(clipboardItem.getUpdatedAt());
        return dto;
    }

    public ClipboardItem toEntity(ClipboardItemDTO dto) {
        ClipboardItem clipboardItem = new ClipboardItem();
        clipboardItem.setId(dto.getId());
        clipboardItem.setText(dto.getText());
        clipboardItem.setAttachedFiles(dto.getAttachedFiles());
        clipboardItem.setExpiration(dto.getExpiration());
        clipboardItem.setCretedAt(dto.getCretedAt());
        clipboardItem.setUpdatedAt(dto.getUpdatedAt());
        return clipboardItem;
    }

    public List<ClipboardItemDTO> toDTOList(List<ClipboardItem> clipboardItems) {
        return clipboardItems.stream().map((entity) -> toDTO(entity)).collect(Collectors.toList());
    }

    public List<ClipboardItem> toEntityList(List<ClipboardItemDTO> dtos) {
        return dtos.stream().map((dto) -> toEntity(dto)).collect(Collectors.toList());
    }
}
