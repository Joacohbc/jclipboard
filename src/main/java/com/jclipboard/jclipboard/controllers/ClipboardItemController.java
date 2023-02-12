package com.jclipboard.jclipboard.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jclipboard.jclipboard.dto.ClipboardItemDTO;
import com.jclipboard.jclipboard.exceptions.EntityNotFoundException;
import com.jclipboard.jclipboard.exceptions.JsonError;
import com.jclipboard.jclipboard.services.ClipboardItemService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/clipboard")
public class ClipboardItemController {
    
    @Autowired
    private ClipboardItemService service;

    @ExceptionHandler 
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        return JsonError.of(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ EntityNotFoundException.class})
    public ResponseEntity<Map<String, Object>> handleException(EntityNotFoundException ex) {
        return JsonError.of(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Map<String, Object>> handleException(ConstraintViolationException ex) {
        return JsonError.of(ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toArray(String[]::new), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ClipboardItemDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<ClipboardItemDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<ClipboardItemDTO> save(@RequestBody ClipboardItemDTO clipboardItem) {
        return ResponseEntity.ok(service.save(clipboardItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClipboardItemDTO> update(@PathVariable Long id, @RequestBody ClipboardItemDTO clipboardItem) {
        return ResponseEntity.ok(service.save(clipboardItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
