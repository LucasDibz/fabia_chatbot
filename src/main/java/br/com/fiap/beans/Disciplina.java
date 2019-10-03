package br.com.fiap.beans;

public class Disciplina {
	private int codigo;
	private String nome;
	private int status;

	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disciplina(int codigo, String nome, int status) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
