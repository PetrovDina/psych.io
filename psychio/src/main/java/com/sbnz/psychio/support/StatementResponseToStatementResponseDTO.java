package com.sbnz.psychio.support;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.sbnz.psychio.dto.StatementResponseDTO;
import com.sbnz.psychio.model.StatementResponse;

@Component
public class StatementResponseToStatementResponseDTO implements Converter<StatementResponse, StatementResponseDTO> {

    @Override
    public StatementResponseDTO convert(StatementResponse source) {
        return new StatementResponseDTO(source.getId(), source.getStatement().getId(),
                source.getStatement().getContent(), source.getResponse());
    }

    public List<StatementResponseDTO> convert(List<StatementResponse> statementResponses) {
        return statementResponses.stream().map(this::convert).collect(Collectors.toList());
    }

}
