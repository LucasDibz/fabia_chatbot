package br.com.fiap.bo;

import br.com.fiap.beans.Progressao;
import br.com.fiap.dao.ProgressaoDAO;

public class ProgressaoBO {
	public String addProgressao(Progressao prog) throws Exception {
		ProgressaoDAO progressaodao = new ProgressaoDAO();
		Progressao progressao = progressaodao.getProgressao(prog.getConteudo().getCodigo(), prog.getAluno().getRm(),
				prog.getDisciplina().getCodigo());

		if (progressao.getDisciplina().getCodigo() == 0)
			return "O codigo é obrigatorio";

		if (progressao.getConteudo().getCodigo() < 0)
			return "Codigo deve ser positivo";

		if (progressao.getConteudo().getCodigo() == 0)
			return "O codigo é obrigatorio";

		if (progressao.getAluno().getRm() == 0)
			return "RM é Obrigatorio";
		// Qtd RM
		if (progressao.getAluno().getRm() <= 5 || progressao.getAluno().getRm() >= 5)
			return "RM deve possuir 5 digitos";
		progressaodao.addProgressao(prog);
		progressaodao.close();
		return "Progressao Cadastrada";

	}
////////////////////////////////////////////
	public String updateProgressao(int status, int cd_conteudo, int cd_disciplina,Progressao prog) throws Exception {
	ProgressaoDAO progressaoDAO = new ProgressaoDAO();

		
		int x = progressaoDAO.updateProgressao(prog.getProgressao(),  prog.getAluno().getRm(), prog.getConteudo().getCodigo());
		if (x == 0)
			return "Progressao não localizada";
		else
			return "Progressao Atualizada!";	
}
	
	///////////////////////////////////
	public String updateStatusProgressao(int status, int cd_conteudo, int cd_disciplina,Progressao prog) throws Exception{
		ProgressaoDAO progressaoDAO = new ProgressaoDAO();
	
		
		int x = progressaoDAO.updateStatus(prog.getStatus(),prog.getConteudo().getCodigo(), prog.getDisciplina().getCodigo());
		if (x == 0)
			return "Status da Progressao não localizada";
		else
			return "Status da  Progressao Atualizada!";	
	}
	//////////////////////
	public String deletarProgressao(Progressao prog) throws Exception {
		ProgressaoDAO progressaodao = new ProgressaoDAO();

		progressaodao.deleteProgressao(prog);
		progressaodao.close();
		return "Progressao deletada";

	}
}
