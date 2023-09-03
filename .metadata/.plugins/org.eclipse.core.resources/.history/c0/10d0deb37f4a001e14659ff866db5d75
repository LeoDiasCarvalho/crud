package com.leo.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.crud.dto.TelefoneDTO;
import com.leo.crud.entities.Telefone;
import com.leo.crud.repositories.TelefoneRepository;

@RestController
@CrossOrigin
@RequestMapping("/telefones")
public class TelefoneController {
	
	@Autowired
	private TelefoneRepository repo;
	
	@GetMapping
	public List<TelefoneDTO> buscarTodosTelefones(){
		List<Telefone> list = repo.findAll();
		return list.stream().map(TelefoneDTO::new).toList(); 
	}
	
	@GetMapping(value = "/{id}")
	public TelefoneDTO buscarTelefonePorId(@PathVariable Long id) {
		Telefone tel = repo.findById(id).get();
		return new TelefoneDTO(tel);
	}
	
	@PostMapping
	public TelefoneDTO salvarTelefone(Telefone tel) {
		Telefone novoTel = repo.save(tel);
		return new TelefoneDTO(novoTel);
	}
	
	@PutMapping(value = "/{id}")
	public TelefoneDTO atualizarTelefone(@PathVariable Long id) {
		Telefone tel = repo.findById(id).get();
		Telefone novoTel = repo.save(tel);
		return new TelefoneDTO(novoTel);
	}

}
