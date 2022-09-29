package br.com.jflorentino.TrabFinalSpringBFS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Assunto;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.AssuntoRepository;

@Service
public class AssuntoService {
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	//Metodos de pesquisa e exclusão
	public List<Assunto> findAll() {
		return assuntoRepository.findAll();
	}
	
	public Assunto findById(Long id) {
		return assuntoRepository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		assuntoRepository.deleteById(id);
    }
	
	
	//Metodo para salvar as alteraçoes no banco de dados
	public Assunto save(Assunto assunto) {
		return assuntoRepository.save(assunto);
	}
	
	public Assunto update(Long id, Assunto assunto) {
	    Assunto assuntoEntity = assuntoRepository.getReferenceById(id);
	    
	    assuntoEntity.setDescricao(assunto.getDescricao());
		
		return assuntoRepository.save(assuntoEntity);
    }
	
	
	

}
