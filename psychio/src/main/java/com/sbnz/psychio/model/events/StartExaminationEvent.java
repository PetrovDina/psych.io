package com.sbnz.psychio.model.events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

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
public class StartExaminationEvent implements Serializable {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private String username;

    public StartExaminationEvent(String username) {
        super();
        this.executionTime = new Date();
        this.username = username;
    }
}
