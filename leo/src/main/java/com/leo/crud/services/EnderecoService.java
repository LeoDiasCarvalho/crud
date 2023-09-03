package com.leo.crud.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.crud.dto.EnderecoDTO;
import com.leo.crud.entities.Endereco;
import com.leo.crud.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	private EnderecoRepository repo;
	
	@Transactional(readOnly = true)
	public List<EnderecoDTO> buscarTodosEnderecos(){
			List<Endereco> list = repo.findAll();
			return list.stream().map(EnderecoDTO::new).toList();	
	}
	
	@Transactional(readOnly = true)
	public EnderecoDTO buscarEnderecoPorId(Long id) {
			Endereco obj = repo.findById(id).get();
			return new EnderecoDTO(obj);
	}
	
	@Transactional(readOnly = false)
	public Endereco salvarEndereco(Endereco end) {
			Endereco obj = repo.save(end);
			return obj;	
	}
	
	@Transactional(readOnly = false)
	public Endereco atualizarEndereco(Endereco end) {
			Endereco obj =  repo.save(end);
			return obj;
	}
	
	@Transactional(readOnly = false)
	public Endereco excluirEndereco(Long id) {
		if(repo.existsById(id)) {
			Endereco obj = repo.findById(id).get();
			repo.delete(obj);
			return obj;
		}else {
			return null;
		}
		
	}

}
