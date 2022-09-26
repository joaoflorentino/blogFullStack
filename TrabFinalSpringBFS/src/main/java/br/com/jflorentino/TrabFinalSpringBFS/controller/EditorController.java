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

import br.com.jflorentino.TrabFinalSpringBFS.entities.Editor;
import br.com.jflorentino.TrabFinalSpringBFS.services.EditorService;

@RestController
public class EditorController {
	
	@Autowired
	private EditorService editorService;
	
	@GetMapping(value = "/editor")
	public ResponseEntity<List<Editor>> getEditor(){
		List<Editor> editor = editorService.findAll();
		return ResponseEntity.ok().body(editor);
	}
	
	@GetMapping(value = "/editor/{id}")
	public ResponseEntity<Editor> getEditorById(@PathVariable Long id){
		Editor a = editorService.findById(id);
		return ResponseEntity.ok().body(a);
		
	}
	
	@PostMapping(value = "/editor")
    public ResponseEntity<Editor> save(@RequestBody Editor editor){
       Editor savedEditor = editorService.save(editor);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("editor/{id}").buildAndExpand(savedEditor.getId()).toUri();
    return ResponseEntity.created(uri).body(savedEditor);
}  //created(uri) - retorna o codigo HTTP 201:(CREATED) objeto criado com sucesso
	
}
