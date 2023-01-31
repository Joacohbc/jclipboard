package com.jclipboard.jclipboard.services;

import java.util.List;

import com.jclipboard.jclipboard.dto.ClipboardItemDTO;

public interface ClipboardItemService {
    List<ClipboardItemDTO> getAll();
    ClipboardItemDTO getById(Long id);
    ClipboardItemDTO save(ClipboardItemDTO ClipboardItem);
    void deleteById(Long id);
}
