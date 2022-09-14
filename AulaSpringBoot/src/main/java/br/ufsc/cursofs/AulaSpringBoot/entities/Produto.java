package br.ufsc.cursofs.AulaSpringBoot.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private Double preco;
	private Double quantidade;
	
	//Implementacao do relacionamento
	@ManyToMany
	@JoinTable(name = "produto_categoria", joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name ="categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	//Contrutores
	//Construtor vazio
	public Produto() {}
	
	//Construtor completo com todos os atributos
	public Produto(Long id, String descricao, Double preco, Double quantidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	//End Getrs & Setrs

	// hashcode e Equals (apenas para atributo que identifica a classe o Id)
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	//Ende hashcode e Equals

	
	
	
}
