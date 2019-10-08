package br.com.fiap.bo;

import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;

import br.com.fiap.dao.DisciplinaDAO;

public class DisciplinaBO {
	public String novaDisciplina(Disciplina dis) throws Exception {
		DisciplinaDAO discdao = new DisciplinaDAO();
		Disciplina disci = discdao.getDisciplina(dis.getCodigo());

		if (dis.getCodigo() < 0)
			return "Codigo deve ser positivo";

		if (dis.getCodigo() == 0)
			return "O codigo é obrigatorio";
		if (dis.getNome() == null)
			return "Nome da disciplina é Obrigatorio";
		if (disci.getCodigo() > 0)
			return "Disciplina já existe!";
		// QTD LETRAS!!!!!!!!!!!!!!!!!!!!!!!
		int qtdLetras = 0;
		for (int i = 0; i < dis.getNome().length(); i++)
			if (Character.isLetter(dis.getNome().charAt(i)))
				qtdLetras++;
		if (qtdLetras < 6 || qtdLetras > 30)
			return "Quantidade de Letras Inválida";
		// Qtd numeros
		if (dis.getCodigo() <= 2 || dis.getCodigo() >= 1)
			return "O codigo da disciplina deve ter entre um a dois numeros";

		// Se tudo certo
		discdao.addDisciplina(dis);
		discdao.close();
		return "Disciplina Cadastrada";
	}

	public Disciplina buscaDisciplina(int cod) throws Exception {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina d = disciplinaDAO.getDisciplina(cod);
		if (d.getCodigo() == 0)
			return null;
		else {
			return d;
		}
	}

	public String atualizaDisciplina(int codigo, int status) throws Exception {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		int x = disciplinaDAO.updateStatus(codigo, status);
		if (x == 0)
			return "Cadastro não localizado";
		else
			return "Status Atualizado!";
	}
	public String deletarDisciplina (Conteudo cont,Disciplina dis) throws Exception{
		DisciplinaDAO discdao = new DisciplinaDAO();
		Disciplina disci = discdao.getDisciplina(dis.getCodigo());

		
		discdao.deleteDisciplina(disci.getCodigo());
		discdao.close();
		return "Disciplina deletada";
		
	}

}
