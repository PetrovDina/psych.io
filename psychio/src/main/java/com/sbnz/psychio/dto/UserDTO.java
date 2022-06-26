package com.sbnz.psychio.dto;

import com.sbnz.psychio.model.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public String username;
    public String password;
    public UserRole role;
    
}
