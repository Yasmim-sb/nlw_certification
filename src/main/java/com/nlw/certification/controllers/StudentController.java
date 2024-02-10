package com.nlw.certification.controllers;

import com.nlw.certification.dto.VerifyHasCertificationDTO;
import com.nlw.certification.useCases.VerifyHasCertificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final VerifyHasCertificationUseCase verifyHasCertificationUseCase;

    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){


        var result = this.verifyHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if(result){
            return "Usuario ja fez a prova";
        }
        return "Usuario pode fazer a prova";
    }
}
