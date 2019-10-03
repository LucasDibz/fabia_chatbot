package br.com.fiap.beans;

public class Conteudo {
	private int codigo;
	private int cd_disciplina;
	private String titulo;
	private String local;

	public Conteudo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conteudo(int codigo, int cd_disciplina, String titulo, String local) {
		super();
		this.codigo = codigo;
		this.cd_disciplina = cd_disciplina;
		this.titulo = titulo;
		this.local = local;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCd_disciplina() {
		return cd_disciplina;
	}

	public void setCd_disciplina(int cd_disciplina) {
		this.cd_disciplina = cd_disciplina;
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

}
