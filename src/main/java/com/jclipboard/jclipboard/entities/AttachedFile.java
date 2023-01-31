package com.jclipboard.jclipboard.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "attached_files")
public class AttachedFile {
    
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
    
    @CreationTimestamp
    @Column(name = "created_at")
    private Date cretedAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
