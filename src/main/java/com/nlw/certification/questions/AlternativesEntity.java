package com.nlw.certification.questions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name= "alternatives")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlternativesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    private boolean isCorrect;

    private String description;

    @CreationTimestamp
    private LocalDateTime createAt;

}
