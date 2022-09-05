package br.ufsc.cursofs.AulaSpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;
import br.ufsc.cursofs.AulaSpringBoot.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping(value = "/clientes")
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> clientes = clienteService.findAll();		
		return ResponseEntity.ok().body(clientes);		
	}
	
	@GetMapping(value = "/clientes/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		
		Cliente c = clienteService.findById(id);
		return ResponseEntity.ok().body(c);		
		
	}
	
	

}
