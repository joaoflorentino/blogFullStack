package br.com.jflorentino.TrabFinalSpringBFS.test;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.jflorentino.TrabFinalSpringBFS.entities.Assunto;
import br.com.jflorentino.TrabFinalSpringBFS.entities.Comentario;
import br.com.jflorentino.TrabFinalSpringBFS.entities.Editor;
import br.com.jflorentino.TrabFinalSpringBFS.entities.Postagem;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.AssuntoRepository;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.ComentarioRepository;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.EditorRepository;
import br.com.jflorentino.TrabFinalSpringBFS.repositories.PostagemRepository;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner {
	
	// dependency injection
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private EditorRepository editorRepository;
	
	
	
	// Dados a serem adicionados no banco de dados no start do Spring
	@Override
		//Assuntos
	public void run(String... args) throws Exception {
		//Assuntos 
	    Assunto a1 = new Assunto(null, "Astrofisica");
	    Assunto a2 = new Assunto(null, "Fisica Quantica");
	    Assunto a3 = new Assunto(null, "James Web");
	    Assunto a4 = new Assunto(null, "Matematica");
	    Assunto a5 = new Assunto(null, "Quimica");
	    Assunto a6 = new Assunto(null, "Introducao ao Full Stack");

	    assuntoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6));
	    
	    //Comentarios
	    Comentario c1 = new Comentario(null,"Descoberta de novos planetas" ,Instant.parse("2021-10-20T15:00:00Z"), "Novos planetas descobertos na galaxia TM89A-09 pelo telescópio Huble");
        Comentario c2 = new Comentario(null,"Nova tecnologia de Foguetes" ,Instant.parse("2021-11-15T15:00:00Z"), "A empresa Space X desenvolve novos propulsores para envio de tripulação a Estação Espacial");
        Comentario c3 = new Comentario(null,"Previsão de laçamento do telescopio James Web", Instant.parse("2021-08-01T15:00:00Z"), "O lançamento do novo telescopio esta agendado para Dezembro de 2021 em um sabado rumo a orbita L2");
        Comentario c4 = new Comentario(null,"Equções Diferenciais", Instant.parse("2022-05-01T15:00:00Z"), "Comentario sobre as equações diferenciais criadas por Isac Newton e Lagrange");
        Comentario c5 = new Comentario(null,"Quimica dos acidos do DNA", Instant.parse("2022-02-20T15:00:00Z"), "Observação dos ácidos que compoe o DNA pode ser observados em varios minerais");
        Comentario c6 = new Comentario(null,"Neutrinos", Instant.parse("2020-10-20T15:00:00Z"), "Neutrinos provenientes do Sol podem exercer influencia nos núcleos atômicos");
        Comentario c7 = new Comentario(null,"Novo Sistema Operacional", Instant.parse("2022-04-10T15:00:00Z"), "Novo sistema operacional Linux Mint traz diversas ferramentas para desenvolvedores de apliativos para todas as plataformas");
	    
        comentarioRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
        
	    //Editor
        Editor e1 = new Editor(null, "Arthur C Clark","Boss1988");
        Editor e2 = new Editor(null, "Paster","Pari1877");
        Editor e3 = new Editor(null, "Pascal","Ingles1213");
        Editor e4 = new Editor(null, "Carl Segan","Voyager1979");
        Editor e5 = new Editor(null, "Ctistan Gale","virtua14");
        
        editorRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
        
	    //Postagem
        
        Postagem p1 = new Postagem(null, Instant.parse("2021-10-20T15:00:00Z"),"Descoberta de novos planetas" , "Novos planetas descobertos na galaxia TM89A-09 pelo telescópio Huble");
        Postagem p2 = new Postagem(null, Instant.parse("2021-11-15T15:00:00Z"),"Nova tecnologia de Foguetes" , "A empresa Space X desenvolve novos propulsores para envio de tripulação a Estação Espacial");
        Postagem p3 = new Postagem(null, Instant.parse("2021-08-01T15:00:00Z"),"Previsão de laçamento do telescopio James Web",  "O lançamento do novo telescopio esta agendado para Dezembro de 2021 em um sabado rumo a orbita L2");
        Postagem p4 = new Postagem(null, Instant.parse("2022-05-01T15:00:00Z"),"Equções Diferenciais",  "A Historia das equações diferenciais criadas por Isac Newton e Lagrange");
        Postagem p5 = new Postagem(null, Instant.parse("2022-02-20T15:00:00Z"),"Quimica dos acidos do DNA",  "Observação dos ácidos que compoe o DNA pode ser observados em varios minerais");
        Postagem p6 = new Postagem(null, Instant.parse("2020-10-20T15:00:00Z"), "Neutrinos",  "Neutrinos provenientes do Sol podem exercer influencia nos núcleos atômicos");
        Postagem p7 = new Postagem(null, Instant.parse("2022-04-10T15:00:00Z"),"Novo Sistema Operacional",  "Novo sistema operacional Linux Mint traz diversas ferramentas para desenvolvedores de apliativos para todas as plataformas");
	    
        postagemRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
	    
	    
	}
	
	
	
	
	
}
