package br.com.jflorentino.TrabFinalSpringBFS.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Comentario;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.ComentarioRepository;

@Service
public class ComentarioService {
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public List<Comentario> findAll() {
		return comentarioRepository.findAll();
	}
	
	public Comentario findById(Long id) {
		try {
		return comentarioRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new EntityNotFoundException("Elemento não encontrado com Postagem id: " + id);
		}
	}
	
	public Comentario save(Comentario comentario){
        return comentarioRepository.save(comentario);
	}
	
	public void deleteById(Long id) {
		comentarioRepository.deleteById(id);
    }
	
	public Comentario update(Long id, Comentario comentario) {
	    Comentario comentarioEntity = comentarioRepository.getReferenceById(id);

    comentarioEntity.setNome(comentario.getNome());
    comentarioEntity.setData(comentario.getData());
    comentarioEntity.setText(comentario.getText());
	
	return comentarioRepository.save(comentarioEntity);

    }

}
