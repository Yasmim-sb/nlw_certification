package com.nlw.certification.questions.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuestionResultDTO {

    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    private String technology;
    private String description;

    private List<AlternativeResultDTO> alternative;
}
