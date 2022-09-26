package br.com.jflorentino.TrabFinalSpringBFS.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping(value = "/comentario")
    public ResponseEntity<Comentario> save(@RequestBody Comentario comentario){
       Comentario savedComentario = comentarioService.save(comentario);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("comentario/{id}").buildAndExpand(savedComentario.getId()).toUri();
    return ResponseEntity.created(uri).body(savedComentario);
}  //created(uri) - retorna o codigo HTTP 201:(CREATED) objeto criado com sucesso
	
	
}
