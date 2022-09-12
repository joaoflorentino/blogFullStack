package br.ufsc.cursofs.AulaSpringBoot.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;
import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;
import br.ufsc.cursofs.AulaSpringBoot.repositories.ClienteRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.EnderecoRepository;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner{
	
	// dependency injection
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "João da Silva", "joao@gmail.com", "99999999999", "123mudar");
		Cliente c2 = new Cliente(null, "Maria dos Santos", "maria@m.com", "88888888888", "123mudar");
		Cliente c3 = new Cliente(null, "Ana Paula Ferreira", "ana@gmail.com", "77777777777", "123mudar");
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Endereco e1 = new Endereco(null, "casa", "Rua das Palmeiras", "333", "89.001-001", c1);
		Endereco e2 = new Endereco(null, "trabalho", "Rua dos Coqueiros", "222", "89.222-001",c1);
		Endereco e3 = new Endereco(null, "casa", "Rua das Rosas", "111", "91.002-004",c2);
		Endereco e4 = new Endereco(null, "sitio", "Rua dos Cravos", "34", "89.003-007",c2);
		Endereco e5 = new Endereco(null, "trabalho", "Rua das Laranjeiras", "1234", "90.001-001",c3);
		Endereco e6 = new Endereco(null, "trabalho", "Rua das Laranjeiras", "1234", "90.001-001", null);
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3, e4, e5, e6));
		
		
	}
	

}
