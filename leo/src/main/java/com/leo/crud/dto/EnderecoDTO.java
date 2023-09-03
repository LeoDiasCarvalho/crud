package com.leo.crud.dto;

import com.leo.crud.entities.Cidade;
import com.leo.crud.entities.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
	
	private Long id;
	private String logradouro;
	private String bairro;
	private String cep;
	private Cidade cidade;
	
	public EnderecoDTO(Endereco endereco) {
		id = endereco.getId();
		logradouro = endereco.getLogradouro();
		bairro = endereco.getBairro();
		cep = endereco.getCep();
		cidade = endereco.getCidade();
	}

}
