package br.com.jflorentino.TrabFinalSpringBFS.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping(value = "/assunto")
		public ResponseEntity<Assunto> save(@RequestBody Assunto assunto){
		Assunto savedAssunto = assuntoService.save(assunto);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("assunto/{id}")
				.buildAndExpand(savedAssunto.getId()).toUri();
		return ResponseEntity.created(uri).body(savedAssunto);
	} //created(uri) - retorna o codigo HTTP 201:(CREATED) objeto criado com sucesso
	
	@DeleteMapping(value = "/assunto")
    @PutMapping(value = "/assunto/{id}")
	public ResponseEntity<Assunto> update(@PathVariable Long id, @RequestBody Assunto assunto){
		Assunto assuntoAtualizado = assuntoService.update(id, assunto);
		return ResponseEntity.ok().body(assuntoAtualizado);
	}
	
	
}
