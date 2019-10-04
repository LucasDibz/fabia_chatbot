package br.com.fiap.beans;

import java.sql.Date;

public class Matricula {

	private Date inicio;
	private Date termino;
	private Aluno aluno;
	private Disciplina disciplina;

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(Date inicio, Date termino, Aluno aluno, Disciplina disciplina) {
		super();
		this.inicio = inicio;
		this.termino = termino;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
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
}