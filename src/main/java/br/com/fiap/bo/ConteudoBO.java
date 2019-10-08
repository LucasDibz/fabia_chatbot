package br.com.fiap.bo;

import br.com.fiap.beans.Conteudo;
import br.com.fiap.dao.ConteudoDAO;



public class ConteudoBO {
	public String novoConteudo(Conteudo cont) throws Exception {
		ConteudoDAO conteudoDAO = new ConteudoDAO();
		Conteudo conteudo = conteudoDAO.getConteudo(cont.getCodigo());

		if (cont.getCodigo() < 0)
			return "Codigo deve ser positivo";

		if (cont.getCodigo() == 0)
			return "O codigo é obrigatorio";
		if (cont.getTitulo() == null)
			return "O titulo do Conteudo  é obrigatorio";
		if (conteudo.getCodigo() > 0)
			return "O conteudo já existe!";
		// QTD LETRAS!!!!!!!!!!!!!!!!!!!!!!!
		int qtdLetras = 0;
		for (int i = 0; i < cont.getTitulo().length(); i++)
			if (Character.isLetter(cont.getTitulo().charAt(i)))
				qtdLetras++;
		if (qtdLetras < 6 || qtdLetras > 80)
			return "Quantidade de Letras Inválida";
		// qtde letras local

		int qtdLetrasLocal = 0;
		for (int i = 0; i < cont.getTitulo().length(); i++)
			if (Character.isLetter(cont.getTitulo().charAt(i)))
				qtdLetrasLocal++;
		if (qtdLetrasLocal < 2 || qtdLetrasLocal > 80)
			return "Quantidade de Letras para o Local Inválida";

		// Qtd numeros
		if (cont.getCodigo() <= 3 || cont.getCodigo() >= 1)
			return "O codigo do Conteudo deve ter entre um a a três numeros";

		// Se tudo certo
		conteudoDAO.addConteudo(cont);
		conteudoDAO.close();
		return "Conteudo Cadastrado";
	}

	public String atualizarLocalConteudo(int codigo, String local, Conteudo cont) throws Exception {
		ConteudoDAO conteudoDAO = new ConteudoDAO();
		int qtdLetrasLocal = 0;
		for (int i = 0; i < cont.getTitulo().length(); i++)
			if (Character.isLetter(cont.getTitulo().charAt(i)))
				qtdLetrasLocal++;
		if (qtdLetrasLocal < 2 || qtdLetrasLocal > 80)
			return "Quantidade de Letras para o Local Inválida";

		int x = conteudoDAO.updateConteudo(codigo, local);
		if (x == 0)
			return "Conteudo não localizado";
		else
			return "Conteudo Atualizado!";
	}
	
	public String atualizarTituloConteudo(int codigo, String local, Conteudo cont) throws Exception {
		ConteudoDAO conteudoDAO = new ConteudoDAO();
		// Letras Titulo
		int qtdLetras = 0;
		for (int i = 0; i < cont.getTitulo().length(); i++)
			if (Character.isLetter(cont.getTitulo().charAt(i)))
				qtdLetras++;
		if (qtdLetras < 6 || qtdLetras > 80)
			return "Quantidade de Letras Inválida";
		// qtde letras local
		
		int x = conteudoDAO.updateConteudo(codigo, local);
		if (x == 0)
			return "Conteudo não localizado";
		else
			return "Conteudo Atualizado!";
	}
	public String deletarConteudo (Conteudo cont) throws Exception{
		ConteudoDAO conteudoDAO = new ConteudoDAO();
	
		
		conteudoDAO.deleteConteudo(cont);
		conteudoDAO.close();
		return "Conteudo deletado";
		
	}
	
	

}
