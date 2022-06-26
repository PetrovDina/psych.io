
package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.TherapyDTO;
import com.sbnz.psychio.model.Therapy;
import com.sbnz.psychio.service.SubstanceGroupService;
import com.sbnz.psychio.support.TherapyToTherapyDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/therapy", produces = MediaType.APPLICATION_JSON_VALUE)
public class TherapyController {
    private final SubstanceGroupService substanceGroupService;
    private TherapyToTherapyDTO toDTO;

    @GetMapping(value = "/all")
    public ResponseEntity<List<TherapyDTO>> getAll() {

        return new ResponseEntity<List<TherapyDTO>>(toDTO.convert(substanceGroupService.getAllTherapies()), HttpStatus.OK);
    }

    @GetMapping(value = "/allByDiagnosis")
    public ResponseEntity<List<TherapyDTO>> queryTherapiesByDiagnosis(@RequestParam Integer diagnosisId) {

        return new ResponseEntity<List<TherapyDTO>>(toDTO.convert(substanceGroupService.queryTherapiesByDiagnosis(diagnosisId)), HttpStatus.OK);
    }

}
