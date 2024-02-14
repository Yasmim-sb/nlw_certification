package com.nlw.certification.students.controllers;

import com.nlw.certification.students.dto.StudentCertificationAnswerDTO;
import com.nlw.certification.students.dto.VerifyHasCertificationDTO;
import com.nlw.certification.students.entities.CertificationStudentEntity;
import com.nlw.certification.students.useCases.StudentCertificationAnswersUseCase;
import com.nlw.certification.students.useCases.VerifyHasCertificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final VerifyHasCertificationUseCase verifyHasCertificationUseCase;
    private final StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO){


        var result = this.verifyHasCertificationUseCase.execute(verifyHasCertificationDTO);
        if(result){
            return "Usuario ja fez a prova";
        }
         return "Usuario pode fazer a prova";
    }

    @PostMapping("/certification/answer")
    public CertificationStudentEntity certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) throws Exception {
        return this.studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
    }
}
