package com.nlw.certification.students.useCases;

import com.nlw.certification.questions.entities.QuestionEntity;
import com.nlw.certification.questions.repository.QuestionRepository;
import com.nlw.certification.students.dto.StudentCertificationAnswerDTO;
import com.nlw.certification.students.entities.AnswerCertificationsEntity;
import com.nlw.certification.students.entities.CertificationStudentEntity;
import com.nlw.certification.students.entities.Student;
import com.nlw.certification.students.repositories.CertificationStudentRepository;
import com.nlw.certification.students.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentCertificationAnswersUseCase {

    private final StudentRepository studentRepository;

    private final QuestionRepository questionRepository;
    private final CertificationStudentRepository certificationStudentRepository;

    public CertificationStudentEntity execute(StudentCertificationAnswerDTO dto) throws Exception {
        var student = studentRepository.findByEmail(dto.getEmail());

        if(student.isEmpty()){
            throw new Exception("E-mail do estudante incorreto.");
        }


        List<QuestionEntity> questionsEntity = questionRepository.findByTechnology(dto.getTechnology());

        dto.getQuestionAnswers()
             .stream().forEach(questionAnswer -> {
                var question = questionsEntity.stream()
                    .filter(q -> q.getId().equals(questionAnswer.getQuestionID()));

                var findCorrectAlternative = question.findFirst().get().getAlternatives().stream()
                    .filter(alternative -> alternative.isCorrect()).findFirst().get();

                if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID())){
                      questionAnswer.setCorrect(true);
                }else {
                      questionAnswer.setCorrect(false);
                }
            });

        var students = studentRepository.findByEmail(dto.getEmail());

        UUID studentID;
        if(students.isEmpty()){

            var studentCreated = Student.builder().email(dto.getEmail())
            .build();
            studentCreated = studentRepository.save(studentCreated);
            studentID = studentCreated.getId();
        } else{
            studentID = students.get().getId();
        }

        List<AnswerCertificationsEntity> answerCertifications = new ArrayList<>();

        CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
            .technology(dto.getTechnology())
            .studentID(studentID)
            .answerCertificationsEntities(answerCertifications)
            .build();

           var certificationStudentCreated =  certificationStudentRepository.save(certificationStudentEntity);


        return certificationStudentCreated;

    }
}
