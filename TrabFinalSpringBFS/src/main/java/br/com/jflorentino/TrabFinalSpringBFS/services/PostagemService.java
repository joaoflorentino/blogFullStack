package br.com.jflorentino.TrabFinalSpringBFS.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

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
		try {
		return postagemRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new EntityNotFoundException("Elemento não encontrado com Postagem id: " + id);
		}
	}
	
	public Postagem save(Postagem postagem){
        return postagemRepository.save(postagem);
	}
	
	public void deleteById(Long id) {
		postagemRepository.deleteById(id);
    }
	
	public Postagem update(Long id, Postagem postagem) {
	    Postagem postagemEntity = postagemRepository.getReferenceById(id);

    postagemEntity.setData(postagem.getData());
    postagemEntity.setTitulo(postagem.getTitulo());
    postagemEntity.setTexto(postagem.getTexto());
    postagemEntity.setEditor(postagem.getEditor());
	
	return postagemRepository.save(postagemEntity);

    }
	
	

}
