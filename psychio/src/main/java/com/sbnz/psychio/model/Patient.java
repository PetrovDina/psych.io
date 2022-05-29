package com.sbnz.psychio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.sbnz.psychio.model.enums.EmploymentStatus;
import com.sbnz.psychio.model.enums.Gender;
import com.sbnz.psychio.model.enums.MaritalStatus;
import com.sbnz.psychio.model.enums.Severity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDate;

    @Column
    private Gender gender;

    @Column
    private Severity severity;

    @Column
    private MaritalStatus maritalStatus;

    @Column
    private EmploymentStatus employmentStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<Examination> examinations;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
}