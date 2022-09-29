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
public class Postagem {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant data;
	private String titulo;
	private String texto;
	
	//Criação do Relacionamento da Postagem com o Editor
	
	@JsonIgnore //Ignorar a geração de Json aqui para evitar o looping
    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;
	
	//Construtores
	// Construtor Vazio
	public Postagem() {}
	
	// Construtor Vazio	
	public Postagem(Long id, Instant data, String titulo, String texto, Editor editor) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.texto = texto;
		this.editor = editor;
	}

	// Getrs and Setrs
	
	
	
	public Instant getData() {
		return data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	//Metodo de contagem de  palavras
	public double getTotalPalavras(){
		/** Metodo que realiza a contagem de palavras no texto **/
        String[] palavras =  this.texto.split("\\s+");
        return +palavras.length;
	
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
