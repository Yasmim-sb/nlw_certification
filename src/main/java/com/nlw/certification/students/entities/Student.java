package com.nlw.certification.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "student")
    private List<CertificationStudentEntity> certificationStudentEntityList;

}
