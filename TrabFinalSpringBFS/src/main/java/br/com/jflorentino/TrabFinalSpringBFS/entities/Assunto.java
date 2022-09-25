package br.com.jflorentino.TrabFinalSpringBFS.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assunto {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;

	
	//Contrutores 
	//Contrutor Vazio
	public Assunto() {
		
	}
	//Construtor com todos os atributos 
	public Assunto(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	
	//Getrs e Setrs
	
	
	
	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// HASHCode & Equals
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
		Assunto other = (Assunto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
