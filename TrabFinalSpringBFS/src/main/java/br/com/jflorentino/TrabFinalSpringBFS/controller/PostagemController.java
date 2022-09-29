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
	
	@PostMapping(value = "/postagem")
    public ResponseEntity<Postagem> save(@RequestBody Postagem postagem){
       Postagem savedPostagem = postagemService.save(postagem);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("postagem/{id}").buildAndExpand(savedPostagem.getId()).toUri();
    return ResponseEntity.created(uri).body(savedPostagem);
	}  //created(uri) - retorna o codigo HTTP 201:(CREATED) objeto criado com sucesso
	
	@DeleteMapping(value = "/postagem")
    @PutMapping(value = "/postagem/{id}")
    public ResponseEntity<Postagem> update(@PathVariable Long id, @RequestBody Postagem postagem){
	    Postagem postagemAtualizado = postagemService.update(id, postagem);
	    return ResponseEntity.ok().body(postagemAtualizado);

    }
	
	
}
