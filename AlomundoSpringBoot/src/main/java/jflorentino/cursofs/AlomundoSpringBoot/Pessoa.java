package jflorentino.cursofs.AlomundoSpringBoot;

public class Pessoa {
	private Long codigo;
	private String nome;
	
	//Construtores
	public Pessoa() {
		super();
	}

	public Pessoa(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	//Getters & Seters 
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// To String
	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
	
	
	

}
