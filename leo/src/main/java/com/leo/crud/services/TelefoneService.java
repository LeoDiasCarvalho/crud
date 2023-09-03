package com.leo.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.leo.crud.dto.TelefoneDTO;
import com.leo.crud.entities.Telefone;
import com.leo.crud.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repo;
	
	public List<TelefoneDTO> buscarTodosTelefones(){
		if(repo.count() != 0) {
			List<Telefone> list = repo.findAll();
			return list.stream().map(TelefoneDTO::new).toList();
		}else {
			return null;
		}
	}
	
	public TelefoneDTO buscarTelefonePorId(@PathVariable Long id) {
		if(repo.existsById(id) == true) {
			Optional<Telefone> obj = repo.findById(id);
			TelefoneDTO dto = new TelefoneDTO(obj.get()); 
			return dto;
		}else {
			return null;
		}
	}
	
	public TelefoneDTO salvarTelefone(Telefone tel) {
		if(repo.existsById(tel.getId()) == false) {
			Telefone obj = repo.save(tel);
			return new TelefoneDTO(obj);
		}else {
			return null;
		}
	}
	
	public TelefoneDTO atualizarTelefone(@RequestBody Telefone tel) {
		if(repo.existsById(tel.getId()) == true) {
			repo.save(tel);
			return new TelefoneDTO(tel);
		}else {
			return null;
		}
	}

}
