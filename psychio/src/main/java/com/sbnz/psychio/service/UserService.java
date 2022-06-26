package com.sbnz.psychio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sbnz.psychio.model.Patient;
import com.sbnz.psychio.model.User;
import com.sbnz.psychio.model.enums.UserRole;
import com.sbnz.psychio.repository.PatientRepository;
import com.sbnz.psychio.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    public User findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User createPatient(Patient patient) {
        // TODO check if username exists already
        patient.setRole(UserRole.PATIENT);
        return patientRepository.save(patient);
    }

    public User login(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getUsername());
        if (!optionalUser.isPresent()) {
            return null;
        } else if (!optionalUser.get().getPassword().equals(user.getPassword())) {
            return null;
        }

        return optionalUser.get();
    }

}
