package com.sbnz.psychio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Patient {
    private String name;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private Severity severity;
    private MaritalStatus maritalStatus;
    private EmploymentStatus employmentStatus;
    private List<Examination> examinations;
    private List<Diagnosis> diagnoses = new ArrayList<Diagnosis>();
}