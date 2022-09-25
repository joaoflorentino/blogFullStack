package br.com.jflorentino.TrabFinalSpringBFS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Comentario;
import br.com.jflorentino.TrabFinalSpringBFS.services.ComentarioService;

@RestController
public class ComentarioController {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@GetMapping(value = "/comentario")
	public ResponseEntity<List<Comentario>> getComentario(){
		List<Comentario> comentario = comentarioService.findAll();
		return ResponseEntity.ok().body(comentario);
	}
	
	@GetMapping(value = "/comentario/{id}")
	public ResponseEntity<Comentario> getComentarioById(@PathVariable Long id){
		Comentario a = comentarioService.findById(id);
		return ResponseEntity.ok().body(a);
		
	}
	
	
	
}
