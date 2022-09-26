package br.com.jflorentino.TrabFinalSpringBFS.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editor {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	
	//Construtores
	//Construtor Vazio
	public Editor() {}
	//Construtor com todos os atributos
	public Editor(Long id, String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
		Editor other = (Editor) obj;
		return Objects.equals(id, other.id);
	}
	

	
	

}
