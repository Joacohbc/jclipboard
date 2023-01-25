package com.jclipboard.jclipboard.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jclipboard.jclipboard.entities.ClipboardItem;

public interface ClipboardItemRepository extends CrudRepository<ClipboardItem, Long> {
    
}
