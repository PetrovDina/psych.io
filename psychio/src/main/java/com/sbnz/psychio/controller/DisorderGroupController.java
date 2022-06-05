package com.sbnz.psychio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.ExaminationDTO;
import com.sbnz.psychio.service.DisorderGroupService;
import com.sbnz.psychio.support.ExaminationToExaminationDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/disorder-group", produces = MediaType.APPLICATION_JSON_VALUE)
public class DisorderGroupController {
    private final DisorderGroupService disorderGroupService;

    private final ExaminationToExaminationDTO toDTO;

    @PostMapping(value = "/probability")
    public ResponseEntity<ExaminationDTO> getDisorderGroupProbabilities(@RequestBody ExaminationDTO examinationDTO) {

        return new ResponseEntity<ExaminationDTO>(
                toDTO.convert(disorderGroupService.calculateDisorderGroupProbabilites(examinationDTO)), HttpStatus.OK);
    }

}
