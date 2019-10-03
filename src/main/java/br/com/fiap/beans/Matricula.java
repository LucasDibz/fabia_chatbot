package br.com.fiap.beans;

import java.util.Date;

public class Matricula {
	private int rm;
	private int disciplina;
	private Date inicio;
	private Date termino;

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(int rm, int disciplina, Date inicio, Date termino) {
		super();
		this.rm = rm;
		this.disciplina = disciplina;
		this.inicio = inicio;
		this.termino = termino;
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

}
