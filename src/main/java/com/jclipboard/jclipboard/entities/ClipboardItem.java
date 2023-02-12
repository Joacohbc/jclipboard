package com.jclipboard.jclipboard.entities;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Description is required")
    @Column(nullable = true)
    private String description;

    @NotBlank(message = "Text is required")
    @Column(nullable = false)
    private String content;
    
    @NotNull(message = "User is required")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
    
    @OneToMany(mappedBy = "clipboard", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<AttachedFile> attachedFiles;

    @NotNull(message = "Expiration is required")
    @Column(nullable =  false)
    private LocalDateTime expiration;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime cretedAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
