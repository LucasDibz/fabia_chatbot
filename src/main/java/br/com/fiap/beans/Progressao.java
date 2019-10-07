package br.com.fiap.beans;

public class Progressao {
	private Conteudo conteudo;
	private Aluno aluno;
	private Disciplina disciplina; 
	private int status;
	private int progressao;
	public Progressao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Progressao(Conteudo conteudo, Aluno aluno, Disciplina disciplina, int status, int progressao) {
		super();
		this.conteudo = conteudo;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.status = status;
		this.progressao = progressao;
	}
	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProgressao() {
		return progressao;
	}
	public void setProgressao(int progressao) {
		this.progressao = progressao;
	}

	
}
