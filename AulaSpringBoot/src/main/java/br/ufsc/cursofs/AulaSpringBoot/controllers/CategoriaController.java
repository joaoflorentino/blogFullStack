package br.ufsc.cursofs.AulaSpringBoot.controllers;

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

import br.ufsc.cursofs.AulaSpringBoot.entities.Categoria;
import br.ufsc.cursofs.AulaSpringBoot.services.CategoriaService;

@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PutMapping(value = "/categorias/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
		Categoria categoriaAtualizado = categoriaService.update(id, categoria);
		return ResponseEntity.ok().body(categoriaAtualizado);
	}
	
	@DeleteMapping(value = "/categorias/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		categoriaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/categorias")
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
		Categoria categoriaSaved = categoriaService.save(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/categorias/{id}")
				.buildAndExpand(categoriaSaved.getId()).toUri();
		
		return ResponseEntity.created(uri).body(categoriaSaved);		
	}
	
	@GetMapping(value = "/categorias")
	public ResponseEntity<List<Categoria>> findAll(){
		
		List<Categoria> categorias = categoriaService.findAll();		
		return ResponseEntity.ok().body(categorias);		
	}
	
	@GetMapping(value = "/categorias/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		
		Categoria c = categoriaService.findById(id);
		return ResponseEntity.ok().body(c);		
		
	}
	

}
