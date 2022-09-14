package br.ufsc.cursofs.AulaSpringBoot.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufsc.cursofs.AulaSpringBoot.entities.Categoria;
import br.ufsc.cursofs.AulaSpringBoot.entities.Cliente;
import br.ufsc.cursofs.AulaSpringBoot.entities.Endereco;
import br.ufsc.cursofs.AulaSpringBoot.entities.Produto;
import br.ufsc.cursofs.AulaSpringBoot.repositories.CategoriaRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.ClienteRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.EnderecoRepository;
import br.ufsc.cursofs.AulaSpringBoot.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner{
	
	// dependency injection
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	// Dados a serem adicionados no banco de dados no start do Spring
	@Override
	public void run(String... args) throws Exception {
		//CLIENTES
		Cliente c1 = new Cliente(null, "João da Silva", "joao@gmail.com", "99999999999", "123mudar");
		Cliente c2 = new Cliente(null, "Maria dos Santos", "maria@m.com", "88888888888", "123mudar");
		Cliente c3 = new Cliente(null, "Ana Paula Ferreira", "ana@gmail.com", "77777777777", "123mudar");
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		//ENDERECOS 
		Endereco e1 = new Endereco(null, "casa", "Rua das Palmeiras", "333", "89.001-001", c1);
		Endereco e2 = new Endereco(null, "trabalho", "Rua dos Coqueiros", "222", "89.222-001",c1);
		Endereco e3 = new Endereco(null, "casa", "Rua das Rosas", "111", "91.002-004",c2);
		Endereco e4 = new Endereco(null, "sitio", "Rua dos Cravos", "34", "89.003-007",c2);
		Endereco e5 = new Endereco(null, "trabalho", "Rua das Laranjeiras", "1234", "90.001-001",c3);
		Endereco e6 = new Endereco(null, "trabalho", "Rua das Laranjeiras", "1234", "90.001-001", null);
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3, e4, e5, e6));
		//PRODUTOS E CATEGORIAS
		
		Produto p1 = new Produto(null, "Produto 1", 10d, 25.5);
		Produto p2 = new Produto(null, "Produto 2", 33d, 66d);
		Produto p3 = new Produto(null, "Produto 3", 21.10d, 32.5);
		Produto p4 = new Produto(null, "Produto 4", 12d, 25d);
		Produto p5 = new Produto(null, "Produto 5", 1000d, 5.2);
		Produto p6 = new Produto(null, "Produto 6", 300d, 86.3);

		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

		Categoria ca1 = new Categoria(null, "Categoria 1");
		Categoria ca2 = new Categoria(null, "Categoria 2");
		Categoria ca3 = new Categoria(null, "Categoria 3");
		Categoria ca4 = new Categoria(null, "Categoria 4");
		Categoria ca5 = new Categoria(null, "Categoria 5");
		Categoria ca6 = new Categoria(null, "Categoria 6");
		Categoria ca7 = new Categoria(null, "Categoria 7");

		categoriaRepository.saveAll(Arrays.asList(ca1, ca2, ca3, ca4, ca5, ca6, ca7));

		p1.getCategorias().add(ca1);
		p1.getCategorias().add(ca2);
		p1.getCategorias().add(ca3);
		p2.getCategorias().add(ca2);
		p2.getCategorias().add(ca3);
		p3.getCategorias().add(ca3);
		p3.getCategorias().add(ca4);
		p4.getCategorias().add(ca3);
		p4.getCategorias().add(ca4);
		p5.getCategorias().add(ca5);
		p5.getCategorias().add(ca6);
		p6.getCategorias().add(ca7);

		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
	}
	

}
