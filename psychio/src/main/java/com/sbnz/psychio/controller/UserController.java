package com.sbnz.psychio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.User;
import com.sbnz.psychio.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/registerPatient")
    public ResponseEntity<User> registerPatient(@RequestBody Patient patient) {

        return new ResponseEntity<User>(userService.createPatient(patient), HttpStatus.OK);
    }

    
}
