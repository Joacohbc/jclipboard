package com.jclipboard.jclipboard.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jclipboard.jclipboard.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
