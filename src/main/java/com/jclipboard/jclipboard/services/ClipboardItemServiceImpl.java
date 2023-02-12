package com.jclipboard.jclipboard.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jclipboard.jclipboard.dto.ClipboardItemDTO;
import com.jclipboard.jclipboard.dto.ClipboardItemMapper;
import com.jclipboard.jclipboard.exceptions.EntityNotFoundException;
import com.jclipboard.jclipboard.exceptions.InvalidEntityException;
import com.jclipboard.jclipboard.repositories.ClipboardItemRepository;

import jakarta.validation.Valid;

@Service
public class ClipboardItemServiceImpl implements ClipboardItemService {

    @Autowired
    private ClipboardItemRepository repository;

    @Autowired
    private ClipboardItemMapper mapper;

    @Override
    public List<ClipboardItemDTO> getAll() {
        return mapper.toListDTO(
                StreamSupport
                        .stream(repository.findAll().spliterator(), false)
                        .collect(Collectors.toList()));
    }

    @Override
    public ClipboardItemDTO getById(Long id) {
        return mapper.toDTO(
                repository.findById(id).orElseThrow(() -> {
                    return new EntityNotFoundException("Clipboard item not found");
                }));
    }

    @Override
    public ClipboardItemDTO save(@Valid ClipboardItemDTO dto) {
        if(dto.getExpiration().isBefore(LocalDateTime.now())) {
            throw new InvalidEntityException("Expiration date must be in the future");
        }

        return mapper.toDTO(
                repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Clipboard item not found");
        }

        repository.deleteById(id);
    }

}
