package br.com.jflorentino.TrabFinalSpringBFS.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Assunto;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.AssuntoRepository;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner {
	
	// dependency injection
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	
	
	
	// Dados a serem adicionados no banco de dados no start do Spring
	@Override
		//Assuntos
	public void run(String... args) throws Exception {
	    Assunto a1 = new Assunto(null, "Astrofisica");
	    Assunto a2 = new Assunto(null, "Fisica Quantica");
	    Assunto a3 = new Assunto(null, "James Web");
	    Assunto a4 = new Assunto(null, "Matematica");
	    Assunto a5 = new Assunto(null, "Quimica");
	    Assunto a6 = new Assunto(null, "Introducao ao Full Stack");

	    assuntoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6));
	}
	
	
	
}
