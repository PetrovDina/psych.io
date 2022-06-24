package com.sbnz.psychio.model;

import static javax.persistence.InheritanceType.JOINED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import com.sbnz.psychio.model.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "system_user")
@Inheritance(strategy=JOINED)
public class User {
    @Id
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role; //PATIENT or DOCTOR
    
}
