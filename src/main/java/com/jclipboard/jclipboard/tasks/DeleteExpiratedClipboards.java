package com.jclipboard.jclipboard.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jclipboard.jclipboard.entities.ClipboardItem;
import com.jclipboard.jclipboard.repositories.ClipboardItemRepository;

@Component
public class DeleteExpiratedClipboards {
    
    private static final Logger log = LoggerFactory.getLogger(DeleteExpiratedClipboards.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private static final int EXPIRATION_TIME = 60 * 1000; // 1 hour

    @Autowired
    private ClipboardItemRepository clipboardItemRepository;

    @Scheduled(fixedDelay = EXPIRATION_TIME)
    public void deleteExpiratedClipboards() {
        log.info("Start delete expirated clipboards {}", dateTimeFormatter.format(LocalDateTime.now()));
        List<ClipboardItem> clipboards = clipboardItemRepository.findExpiredClipboards();
        clipboardItemRepository.deleteAll(clipboards);
        log.info("End delete expirated clipboards {}", dateTimeFormatter.format(LocalDateTime.now()));
    }
}
