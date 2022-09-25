package br.com.jflorentino.TrabFinalSpringBFS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Postagem;
import br.com.jflorentino.TrabFinalSpringBFS.services.PostagemService;

@RestController
public class PostagemController {
	
	@Autowired
	private PostagemService postagemService;
	
	@GetMapping(value = "/postagem")
	public ResponseEntity<List<Postagem>> getPostagem(){
		List<Postagem> postagem = postagemService.findAll();
		return ResponseEntity.ok().body(postagem);
	}
	
	@GetMapping(value = "/postagem/{id}")
	public ResponseEntity<Postagem> getPostagemById(@PathVariable Long id){
		Postagem a = postagemService.findById(id);
		return ResponseEntity.ok().body(a);
		
	}
	
	
	
}
