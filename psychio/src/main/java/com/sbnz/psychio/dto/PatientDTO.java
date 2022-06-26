package com.sbnz.psychio.dto;


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

import com.sbnz.psychio.model.Diagnosis;
import com.sbnz.psychio.model.Examination;
import com.sbnz.psychio.model.User;
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
public class PatientDTO extends UserDTO {
    // @Id
    // private String username;

    private String firstName;

    private String lastName;

    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus employmentStatus;

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    // private List<Examination> examinations;

    // @ManyToMany(fetch = FetchType.LAZY)
    // private List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
}