package com.nlw.certification.students.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentCertificationAnswerDTO {

    private String Email;
    private String technology;
    private List<QuestionAnswersDTO> questionAnswers;
}
