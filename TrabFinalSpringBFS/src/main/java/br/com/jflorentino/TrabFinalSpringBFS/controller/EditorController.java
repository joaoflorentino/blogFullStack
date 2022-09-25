package br.com.jflorentino.TrabFinalSpringBFS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
}
