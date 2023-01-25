package com.jclipboard.jclipboard.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jclipboard.jclipboard.dtos.ClipboardItemDTO;

@Service
public interface ClipboardItemService {
    List<ClipboardItemDTO> getAll();
    ClipboardItemDTO getById(Long id);
    ClipboardItemDTO save(ClipboardItemDTO ClipboardItemDTO);
    void deleteById(Long id);
}
