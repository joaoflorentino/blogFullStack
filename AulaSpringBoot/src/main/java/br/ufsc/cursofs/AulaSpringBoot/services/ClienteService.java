package br.ufsc.cursofs.AulaSpringBoot.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;
import br.ufsc.cursofs.AulaSpringBoot.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteEntity = clienteRepository.getReferenceById(id);
		
		clienteEntity.setEmail(cliente.getEmail());
		clienteEntity.setFone(cliente.getFone());
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setSenha(cliente.getSenha());
		
		return clienteRepository.save(clienteEntity);		
	}
	
	
	public void deleteById(Long id) {
		//try {
			clienteRepository.deleteById(id);
		//}catch (RuntimeException e) {
		//	e.printStackTrace();
		//}
		
	}
	
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {		
		try {
			return clienteRepository.findById(id).get();
		} catch(NoSuchElementException e) {
			throw new EntityNotFoundException("EntityNotFoundException Cliente id: " + id);
		}
	}
	
	
	
}