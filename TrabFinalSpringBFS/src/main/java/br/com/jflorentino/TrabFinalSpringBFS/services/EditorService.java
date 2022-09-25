package br.com.jflorentino.TrabFinalSpringBFS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Editor;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.EditorRepository;

@Service
public class EditorService {
	@Autowired
	private EditorRepository editorRepository;
	
	public List<Editor> findAll() {
		return editorRepository.findAll();
	}
	
	public Editor findById(Long id) {
		return editorRepository.findById(id).get();
	}
	
	

}
