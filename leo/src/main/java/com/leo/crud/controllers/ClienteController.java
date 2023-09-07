package com.leo.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.crud.dto.ClienteDTO;
import com.leo.crud.entities.Cliente;
import com.leo.crud.services.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> buscarTodosClientes(){
		List<ClienteDTO> list = service.buscarTodosClientes();
		return ResponseEntity.status(200).body(list);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id){
		ClienteDTO obj = service.buscarClientePorId(id);
		return ResponseEntity.status(200).body(obj);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody Cliente cliente){
		Cliente obj = service.salvarCliente(cliente);
		ClienteDTO dto = new ClienteDTO(obj);
		return ResponseEntity.status(201).body(dto);
	}
	
	@PutMapping
	public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody Cliente cliente){
		Cliente obj = service.atualizarCliente(cliente, cliente.getId());
		ClienteDTO dto = new ClienteDTO(obj);
		return ResponseEntity.status(200).body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> excluirCliente(@PathVariable Long id){
		Cliente obj = service.excluirCliente(id);
		ClienteDTO dto = new ClienteDTO(obj);
		return ResponseEntity.status(204).body(dto);
	}

}
