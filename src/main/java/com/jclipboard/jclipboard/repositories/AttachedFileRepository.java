package com.jclipboard.jclipboard.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jclipboard.jclipboard.entities.AttachedFile;

public interface AttachedFileRepository extends CrudRepository<AttachedFile, Long> {
    
}
