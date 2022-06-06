package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.DiagnosisProbabilityDTO;
import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.service.DiagnosisService;
import com.sbnz.psychio.support.DiagnosisProbabilityToDiagnosisProbabilityDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/diagnosis", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    private final DiagnosisProbabilityToDiagnosisProbabilityDTO toDTO;

    @PostMapping(value = "/probability")
    public ResponseEntity<List<DiagnosisProbabilityDTO>> getDiagnosisProbabilities(
            @RequestBody ExaminationDTO examinationDTO) {

        return new ResponseEntity<List<DiagnosisProbabilityDTO>>(
                toDTO.convert(diagnosisService.calucateDiagnosisProbabilities(examinationDTO)), HttpStatus.OK);
    }

}
