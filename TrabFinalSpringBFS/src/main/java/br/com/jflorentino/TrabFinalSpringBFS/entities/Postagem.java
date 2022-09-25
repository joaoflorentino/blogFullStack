package br.com.jflorentino.TrabFinalSpringBFS.entities;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Postagem {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant data;
	private String titulo;
	private String texto;
	
	//Construtores
	// Construtor Vazio
	public Postagem() {}
	
	// Construtor Vazio	
	public Postagem(Long id, Instant data, String titulo, String texto) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.texto = texto;
	}

	// Getrs and Setrs
	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
	// Hash and Equals
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
		Postagem other = (Postagem) obj;
		return Objects.equals(id, other.id);
	}
	
	// Hash and Equals
	

}
