package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.DisorderGroupSymptomOccurenceDTO;
import com.sbnz.psychio.dto.SymptomDTO;
import com.sbnz.psychio.service.SymptomService;
import com.sbnz.psychio.support.DisorderGroupSymptomOccurenceToDto;
import com.sbnz.psychio.support.SymptomToSymptomDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/symptom", produces = MediaType.APPLICATION_JSON_VALUE)
public class SymptomController {
    private final SymptomService symptomService;

    private final SymptomToSymptomDTO symptomToDTO;
    private final DisorderGroupSymptomOccurenceToDto occurenceToDTO;


    @GetMapping(value = "/all")
    public ResponseEntity<List<SymptomDTO>> getAll() {

        return new ResponseEntity<List<SymptomDTO>>(symptomToDTO.convert(symptomService.queryAll()), HttpStatus.OK);
    }

    @GetMapping(value = "/allByDisorderGroup")
    public ResponseEntity<List<DisorderGroupSymptomOccurenceDTO>> getAllOccurencesByDisorderGroup(@RequestParam Integer disorderGroupId) {

        return new ResponseEntity<List<DisorderGroupSymptomOccurenceDTO>>(occurenceToDTO.convert(symptomService.queryAllByDisorderGroup(disorderGroupId)), HttpStatus.OK);
    }

}