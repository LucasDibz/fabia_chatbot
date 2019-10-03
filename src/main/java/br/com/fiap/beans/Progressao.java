package br.com.fiap.beans;

public class Progressao {
	private int rm;
	private int disciplina;
	private int conteudo;
	private int status;
	private String avaliacao;

	public Progressao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Progressao(int rm, int disciplina, int conteudo, int status, String avaliacao) {
		super();
		this.rm = rm;
		this.disciplina = disciplina;
		this.conteudo = conteudo;
		this.status = status;
		this.avaliacao = avaliacao;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public int getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(int disciplina) {
		this.disciplina = disciplina;
	}

	public int getConteudo() {
		return conteudo;
	}

	public void setConteudo(int conteudo) {
		this.conteudo = conteudo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

}
