package com.sbnz.psychio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.sbnz.psychio.model.enums.EmploymentStatus;
import com.sbnz.psychio.model.enums.Gender;
import com.sbnz.psychio.model.enums.MaritalStatus;
import com.sbnz.psychio.model.enums.Severity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
public class Patient extends User {
    // @Id
    // private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Examination> examinations;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();

    public List<Examination> getLastThreeExaminations(){
        if (this.examinations.size() < 3){
            System.out.println("EXAMINATION LIST HAS LESS THAN 3 OBJECTS!");
            return this.examinations;
        }
        return this.examinations.subList(Math.max(examinations.size() - 3, 0), examinations.size());

    }
}