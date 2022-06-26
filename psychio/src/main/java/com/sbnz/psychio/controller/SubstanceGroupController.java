package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.model.SubstanceGroup;
import com.sbnz.psychio.service.SubstanceGroupService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/substance-groups", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubstanceGroupController {
    private final SubstanceGroupService substanceGroupService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<SubstanceGroup>> getAll() {

        return new ResponseEntity<List<SubstanceGroup>>(substanceGroupService.findAll(), HttpStatus.OK);
    }

}
