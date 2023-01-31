package com.jclipboard.jclipboard.services;

import java.util.List;

import com.jclipboard.jclipboard.entities.ClipboardItem;

public interface ClipboardItemService {
    List<ClipboardItem> getAll();
    ClipboardItem getById(Long id);
    ClipboardItem save(ClipboardItem ClipboardItem);
    void deleteById(Long id);
}
