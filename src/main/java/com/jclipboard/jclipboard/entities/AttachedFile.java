package com.jclipboard.jclipboard.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "attached_files")
public class AttachedFile implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String path;
    
    @Column(nullable = false)
    private String size;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private ClipboardItem clipboard;
    
    @Column(nullable = false)
    private String extension;
    
    @Column(nullable = false)
    private Date expiration;
}
