package br.com.jflorentino.TrabFinalSpringBFS.entities;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Instant data;
	private String text;
	
	//Relacionamento com a classe Postagem
		@JsonIgnore //Ignorar a geração de Json aqui para evitar o looping
	    @ManyToOne
	    @JoinColumn(name = "comentario_id")
	    private Postagem postagem;
		
	//Construtores
	//Construtor Vazio
	public Comentario() {}
	//Construtor com todos os atributos
	public Comentario(Long id,String nome, Instant data, String text, Postagem postagem) {
		super();
		this.nome = nome;
		this.data = data;
		this.text = text;
		this.postagem = postagem;
	}
	
	//Getrs and Setrs
	
	
	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Instant getData() {
		return data;
	}
	public void setData(Instant data) {
		this.data = data;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Postagem getPostagem() {
		return postagem;
	}
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
	
	//Hash and Equals 
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
