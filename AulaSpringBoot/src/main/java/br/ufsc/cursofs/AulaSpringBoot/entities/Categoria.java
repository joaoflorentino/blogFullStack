package br.ufsc.cursofs.AulaSpringBoot.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	//Contrutores
	//Cobtrutor vazio
	public Categoria() {}
	
	//Contrutoror completo todos os atrib
	public Categoria(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	//End Construtores
	
	
	//Getrs & Setrs
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	//End Getrs & Setrs

	//Hashcode and Equals (apenas para atributo que identifica a classe o Id)
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}
	//End Hashcode and Equals
	
	
	
}
