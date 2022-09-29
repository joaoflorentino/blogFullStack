package br.com.jflorentino.TrabFinalSpringBFS.services;

import java.util.List;

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
		return comentarioRepository.findById(id).get();
	}
	
	public Comentario save(Comentario comentario){
        return comentarioRepository.save(comentario);
	}
	
	

}
