package com.leo.crud.dto;

import com.leo.crud.entities.Cidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CidadeDTO {
	
	private long id;
	private String nome;
	private String estado;
	
	public CidadeDTO(Cidade cidade) {
		id = cidade.getId();
		nome = cidade.getNome();
		estado = cidade.getEstado();
	}
	
	

}
