package br.com.jflorentino.TrabFinalSpringBFS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Postagem;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.PostagemRepository;

@Service
public class PostagemService {
	@Autowired
	private PostagemRepository postagemRepository;
	
	public List<Postagem> findAll() {
		return postagemRepository.findAll();
	}
	
	public Postagem findById(Long id) {
		return postagemRepository.findById(id).get();
	}
	
	public Postagem save(Postagem postagem){
        return postagemRepository.save(postagem);
	}

}
