package com.leo.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.crud.dto.CidadeDTO;
import com.leo.crud.entities.Cidade;
import com.leo.crud.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	@Transactional(readOnly = true)
	public List<CidadeDTO> buscarTodasCidades(){
		List<Cidade> list = repo.findAll();
		return list.stream().map(CidadeDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public CidadeDTO buscarCidadePorId(Long id) {
			Cidade obj = repo.findById(id).get();
			repo.delete(obj);
			return new CidadeDTO(obj);
	}
	
	@Transactional(readOnly = false)
	public Cidade salvarCidade(Cidade cidade) {
		return repo.save(cidade);
	}
	
	@Transactional(readOnly = false)
	public Cidade atualizarCidade(Cidade cidade, Long id) {
		return repo.findById(id).map(atualizar -> {
			atualizar.setNome(cidade.getNome());
			atualizar.setEstado(cidade.getEstado());
			Cidade novaCidade = repo.save(atualizar);
			return novaCidade;
		}).orElse(cidade);
	}
	
	
	@Transactional(readOnly = false)
	public Cidade ExcluirCidade(Long id) {
		if(repo.existsById(id) == true) {
			Cidade obj = repo.findById(id).get();
			repo.delete(obj);
			return obj;
		}else {
			return null;
		}
	}

}
