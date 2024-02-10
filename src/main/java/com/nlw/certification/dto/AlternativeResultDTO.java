package com.nlw.certification.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlternativeResultDTO {

    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    private String description;


}