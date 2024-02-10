package com.nlw.certification.controllers;

import com.nlw.certification.questions.QuestionEntity;
import com.nlw.certification.repositories.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;


    @GetMapping("/technology/{technology}")
    public List<QuestionEntity> findByTechnology(@PathVariable String technology){

     return  this.questionRepository.findByTechnology(technology);
    }
}
