
package com.sbnz.psychio.dto;

import com.sbnz.psychio.model.Symptom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisorderGroupSymptomOccurenceDTO {
    private Integer id;
    private Integer disorderGroupId;
    private SymptomDTO symptom;
    private Integer occurence;

}
