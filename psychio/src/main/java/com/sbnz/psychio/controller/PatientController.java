package com.sbnz.psychio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.model.Diagnosis;
import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.enums.DisorderGroupName;
import com.sbnz.psychio.service.PatientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> test() {
        Patient patient = new Patient();
        patient.getDiagnoses().add(new Diagnosis("test", DisorderGroupName.ANXIETY_DISORDERS));
        return new ResponseEntity<Patient>(patientService.classifySeverity(patient), HttpStatus.OK);
    }
}
