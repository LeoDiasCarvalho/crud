package com.leo.crud.dto;

import java.util.Date;

import com.leo.crud.entities.Cliente;
import com.leo.crud.entities.Endereco;
import com.leo.crud.entities.Telefone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteDTO {
	
	private long id;
	private String nome;
	private String cpf;
	private String email;
	private Date data_nascimento;
	private String nome_mae;
	private Integer numero_casa;
	
	private Telefone telefone;
	private Endereco endereco;
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		email = cliente.getCpf();
		data_nascimento = cliente.getData_nascimento();
		nome_mae = cliente.getNome_mae();
		numero_casa = cliente.getNumero_casa();
		telefone = cliente.getTelefone();
		endereco = cliente.getEndereco();
	}

}
