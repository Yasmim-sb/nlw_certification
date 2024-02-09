package com.nlw.certification.useCases;

import com.nlw.certification.dto.VerifyHasCertificationDTO;
import com.nlw.certification.repositories.CertificationStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class VerifyHasCertificationUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;


    public boolean execute(VerifyHasCertificationDTO dto){
       var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
}
