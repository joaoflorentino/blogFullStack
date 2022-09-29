package br.com.jflorentino.TrabFinalSpringBFS.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PostagemAssunto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Embeddable
	public static class IdPk implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@ManyToOne
		@JoinColumn(name = "postagem_id")
		private Postagem postagem;
		
		@ManyToOne
		@JoinColumn(name = "assunto_id")
		private Assunto assunto;
		public IdPk() {}
		public IdPk(Postagem postagem, Assunto assunto) {
			super();
			this.postagem = postagem;
			this.assunto = assunto;
		}
	
	//Getrs and Setrs 
	
	public Postagem getPostagem() {
		return postagem;
	}
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	public Assunto getAssunto() {
		return assunto;
	}
	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
	
	//HashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postagem == null) ? 0 : postagem.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdPk other = (IdPk) obj;
		if (postagem == null) {
			if (other.postagem != null)
				return false;
		} else if (!postagem.equals(other.postagem))
			return false;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		return true;
		}
	}
	
	@EmbeddedId
	private IdPk id = new IdPk();
	
	public PostagemAssunto() {}
	
	public PostagemAssunto(Postagem postagem, Assunto assunto) {		
		this.id.setPostagem(postagem);
		this.id.setAssunto(assunto);
	}

	public void setPostagem(Postagem postagem) {
		id.setPostagem(postagem);
	}
	
	@JsonIgnore
	public Postagem getPostagem() {
		return id.getPostagem();
	}
	public void setPostagem(Assunto assunto) {
		id.setAssunto(assunto);
	}
	public Assunto getAssunto() {
		return id.getAssunto();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostagemAssunto other = (PostagemAssunto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
