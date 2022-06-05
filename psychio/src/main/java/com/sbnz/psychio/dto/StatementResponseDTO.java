package com.sbnz.psychio.dto;

import com.sbnz.psychio.model.enums.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementResponseDTO {
    private Integer id;
    private Integer statementId;
    private String statement;
    private Response response;
}
