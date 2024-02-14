package com.nlw.certification.questions.controllers;

import com.nlw.certification.questions.dto.AlternativeResultDTO;
import com.nlw.certification.questions.dto.QuestionResultDTO;
import com.nlw.certification.questions.entities.AlternativesEntity;
import com.nlw.certification.questions.entities.QuestionEntity;
import com.nlw.certification.questions.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;


    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){

    var result = this.questionRepository.findByTechnology(technology);

    var toMap = result.stream().map(question -> mapQuestionToDTO(question))
    .collect(Collectors.toList());
    return toMap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity question){
        var questionResultDTO = QuestionResultDTO.builder()
        .id(question.getId())
        .technology(question.getTechnology())
        .description(question.getDescription()).build();

        List<AlternativeResultDTO> alternativeResultDTOs = question.getAlternatives()
        .stream().map(alternative -> mapAlternativeDTO(alternative))
        .collect(Collectors.toList());

        questionResultDTO.setAlternative(alternativeResultDTOs);
        return questionResultDTO;
    }

    static AlternativeResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDTO){

       return AlternativeResultDTO.builder()
       .id(alternativesResultDTO.getId())
        .description(alternativesResultDTO.getDescription()).build();

    }
}
