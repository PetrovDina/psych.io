package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.PatientDTO;
import com.sbnz.psychio.service.PatientService;
import com.sbnz.psychio.support.PatientToPatientDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientService patientService;

    private PatientToPatientDTO toDTO;

   @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<PatientDTO>> getAll() {
       return new ResponseEntity<List<PatientDTO>>(toDTO.convert(patientService.findAll()), HttpStatus.OK);
   }
}
