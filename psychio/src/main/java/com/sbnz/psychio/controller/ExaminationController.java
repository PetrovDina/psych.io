package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.service.ExaminationService;
import com.sbnz.psychio.support.ExaminationToExaminationDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/examination", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExaminationController {
    private final ExaminationService examinationService;

    private final ExaminationToExaminationDTO toDTO;

    @GetMapping(value = "/getAllByUsername")
    public ResponseEntity<List<ExaminationDTO>> getAllByPatient(
            @RequestParam String patientUsername) {

        return new ResponseEntity<List<ExaminationDTO>>(toDTO.convert(examinationService.getAllByPatient(patientUsername)), HttpStatus.OK);
    }

}
