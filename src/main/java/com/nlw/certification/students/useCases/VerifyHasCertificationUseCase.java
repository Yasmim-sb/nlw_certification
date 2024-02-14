package com.nlw.certification.students.useCases;

import com.nlw.certification.students.dto.VerifyHasCertificationDTO;
import com.nlw.certification.students.repositories.CertificationStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyHasCertificationUseCase {


    private  final CertificationStudentRepository certificationStudentRepository;


    public boolean execute(VerifyHasCertificationDTO dto){
       var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
}
