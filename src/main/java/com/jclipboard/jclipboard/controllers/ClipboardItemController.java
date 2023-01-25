package com.jclipboard.jclipboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jclipboard.jclipboard.dtos.ClipboardItemDTO;
import com.jclipboard.jclipboard.dtos.UserDTO;
import com.jclipboard.jclipboard.services.ClipboardItemService;

@RestController
@RequestMapping("/clipboard")
public class ClipboardItemController {
    
    @Autowired
    private ClipboardItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClipboardItemDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ClipboardItemDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<ClipboardItemDTO> save(@RequestBody ClipboardItemDTO dto) {
        UserDTO u = new UserDTO();
        u.setId(1L);
        dto.setUser(u);
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClipboardItemDTO> update(@PathVariable Long id, @RequestBody ClipboardItemDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
