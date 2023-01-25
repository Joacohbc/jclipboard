package com.jclipboard.jclipboard.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jclipboard.jclipboard.dtos.ClipboardItemDTO;
import com.jclipboard.jclipboard.exceptions.EntityNotFoundException;
import com.jclipboard.jclipboard.mappers.ClipboardItemMapper;
import com.jclipboard.jclipboard.repositories.ClipboardItemRepository;

@Service
public class ClipboardItemServiceImpl implements ClipboardItemService {

    @Autowired
    private ClipboardItemRepository repository;

    @Autowired
    private ClipboardItemMapper mapper;

    @Override
    public List<ClipboardItemDTO> getAll() {
        return mapper.toDTOList(StreamSupport.
            stream(repository.findAll().spliterator(), false).
            collect(Collectors.toList()));
    }

    @Override
    public ClipboardItemDTO getById(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Clipboard item not found");
        }));
    }

    @Override
    public ClipboardItemDTO save(ClipboardItemDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
