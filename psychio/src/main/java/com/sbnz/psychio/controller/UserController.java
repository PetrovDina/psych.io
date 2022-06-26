package com.sbnz.psychio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.dto.PatientDTO;
import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.User;
import com.sbnz.psychio.service.UserService;
import com.sbnz.psychio.support.PatientToPatientDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    private final PatientToPatientDTO toDTO;

    @PostMapping(value = "/registerPatient")
    public ResponseEntity<User> registerPatient(@RequestBody Patient patient) {

        return new ResponseEntity<User>(userService.createPatient(patient), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody User user) {

        return new ResponseEntity<User>(userService.login(user), HttpStatus.OK);
    }

    @GetMapping(value = "/patients")
    public ResponseEntity<List<PatientDTO>> getPatients() {

        return new ResponseEntity<List<PatientDTO>>(toDTO.convert(userService.getPatients()), HttpStatus.OK);
    }

    
}
