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
	
	public Editor save(Editor editor){
        return editorRepository.save(editor);
	}
	
	public void deleteById(Long id) {
		editorRepository.deleteById(id);
    }
	
	public Editor update(Long id, Editor editor) {
	    Editor editorEntity = editorRepository.getReferenceById(id);

	    editorEntity.setNome(editor.getNome());
		editorEntity.setSenha(editor.getSenha());
	
		return editorRepository.save(editorEntity);

    }
	
	

}
