package com.jclipboard.jclipboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jclipboard.jclipboard.entities.ClipboardItem;

public interface ClipboardItemRepository extends CrudRepository<ClipboardItem, Long> {

    @Query("SELECT c FROM ClipboardItem c WHERE c.expiration <= CURRENT_TIMESTAMP")
    List<ClipboardItem> findExpiredClipboards();
}