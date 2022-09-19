package br.com.jflorentino.TrabFinalSpringBFS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Assunto;
import br.com.jflorentino.TrabFinalSpringBFS.services.AssuntoService;

@RestController
public class AssuntoController {
	
	@Autowired
	private AssuntoService assuntoService;
	
	@GetMapping(value = "/assunto")
	public ResponseEntity<List<Assunto>> getAssunto(){
		List<Assunto> assunto = assuntoService.findAll();
		return ResponseEntity.ok().body(assunto);
	}
	
	@GetMapping(value = "/assunto/{id}")
	public ResponseEntity<Assunto> getAssuntoById(@PathVariable Long id){
		Assunto a = assuntoService.findById(id);
		return ResponseEntity.ok().body(a);
		
	}
	
	
	
}
