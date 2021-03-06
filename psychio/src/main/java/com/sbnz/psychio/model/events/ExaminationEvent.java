package com.sbnz.psychio.model.events;

import java.io.Serializable;

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
public class ExaminationEvent implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private String username;
    private String comment;
    private List<SymptomFrequency> symptoms;

    private boolean examinationLimit = false;
    private boolean triggerWords = false;
    private boolean hallucinations = false;

    public ExaminationEvent(String username, String comment, List<SymptomFrequency> symptoms) {
        super();
        this.executionTime = new Date();
        this.username = username;
        this.comment = comment;
        this.symptoms = symptoms;
    }
}
