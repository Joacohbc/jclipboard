package com.jclipboard.jclipboard.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jclipboard.jclipboard.entities.ClipboardItem;
import com.jclipboard.jclipboard.exceptions.EntityNotFoundException;
import com.jclipboard.jclipboard.repositories.ClipboardItemRepository;

@Service
public class ClipboardItemServiceImpl implements ClipboardItemService {

    @Autowired
    private ClipboardItemRepository repository;

    @Override
    public List<ClipboardItem> getAll() {
        return StreamSupport.
        stream(repository.findAll().spliterator(), false).
        collect(Collectors.toList());
    }

    @Override
    public ClipboardItem getById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Clipboard item not found");
        });
    }

    @Override
    public ClipboardItem save(ClipboardItem clipboardItem) {
        return repository.save(clipboardItem);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
