package com.jclipboard.jclipboard.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@ToString(exclude = {"attachedFiles"})
@Entity(name = "clipboards")
public class ClipboardItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
    
    @OneToMany(mappedBy = "clipboard", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AttachedFile> attachedFiles;

    @Column(nullable =  false)
    private Date expiration;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date cretedAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}
