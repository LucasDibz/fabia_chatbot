package br.com.fiap.beans;

public class Conteudo {
	private int codigo;
	private String titulo;
	private String local;
	private Disciplina disciplina;

	public Conteudo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conteudo(int codigo, String titulo, String local, Disciplina disciplina) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.local = local;
		this.disciplina = disciplina;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}