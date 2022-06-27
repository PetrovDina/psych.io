package com.sbnz.psychio.model.events;

import java.util.Date;
import java.util.List;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

import com.sbnz.psychio.model.SymptomFrequency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Role(Role.Type.EVENT)
@Timestamp("executionTime")
public class CriticalEvent {
    private Date executionTime;
    private String username;
    private String comment;
    private List<SymptomFrequency> symptoms;

    public CriticalEvent(String username, String comment, List<SymptomFrequency> symptoms) {
        super();
        this.executionTime = new Date();
        this.username = username;
        this.comment = comment;
        this.symptoms = symptoms;
    }

}
