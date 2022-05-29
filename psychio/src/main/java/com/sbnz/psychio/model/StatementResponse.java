package com.sbnz.psychio.model;

import com.sbnz.psychio.model.enums.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementResponse {
	private Statement statement;
	private Response response;

}
