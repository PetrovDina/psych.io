package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.model.Symptom;
import com.sbnz.psychio.service.SymptomService;
import com.sbnz.psychio.support.ExaminationToExaminationDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/symptom", produces = MediaType.APPLICATION_JSON_VALUE)
public class SymptomController {
    private final SymptomService symptomService;

    private final ExaminationToExaminationDTO toDTO;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Symptom>> getAll() {

        return new ResponseEntity<List<Symptom>>(symptomService.queryAll(), HttpStatus.OK);
    }

}