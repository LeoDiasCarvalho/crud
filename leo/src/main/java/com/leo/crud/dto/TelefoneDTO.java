package com.leo.crud.dto;

import com.leo.crud.entities.Telefone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TelefoneDTO {
	
	private Long id;
	private String principal;
	private String recado;
	
	public TelefoneDTO(Telefone tel) {
		id = tel.getId();
		principal = tel.getPrincipal();
		recado = tel.getRecado();
	}

}
