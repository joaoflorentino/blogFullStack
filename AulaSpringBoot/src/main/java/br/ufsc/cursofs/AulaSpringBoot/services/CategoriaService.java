package br.ufsc.cursofs.AulaSpringBoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufsc.cursofs.AulaSpringBoot.entities.Categoria;
import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;
import br.ufsc.cursofs.AulaSpringBoot.repositories.CategoriaRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.EnderecoRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	
	public Categoria update(Long id, Categoria categoria) {
		Categoria categoriaEntity = categoriaRepository.getReferenceById(id);
		
		categoriaEntity.setDescricao(categoria.getDescricao());
		
		
		return categoriaRepository.save(categoriaEntity);		
	}
	
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}

	public Categoria findById(Long id) {		
		try {
			return categoriaRepository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("EntityNotFoundException Categoria id: " + id);
		}
	}
	
	
	
}
