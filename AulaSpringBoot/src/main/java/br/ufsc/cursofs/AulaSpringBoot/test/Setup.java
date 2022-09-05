package br.ufsc.cursofs.AulaSpringBoot.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;
import br.ufsc.cursofs.AulaSpringBoot.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner{
	
	// dependency injection
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "João da Silva", "joao@gmail.com", "99999999999", "123mudar");
		Cliente c2 = new Cliente(null, "Maria dos Santos", "maria@m.com", "88888888888", "123mudar");
		Cliente c3 = new Cliente(null, "Ana Paula Ferreira", "ana@gmail.com", "77777777777", "123mudar");
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	}

}
