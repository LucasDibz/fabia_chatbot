package br.com.fiap.bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

public class AlunoBO {
	public String novoAluno(Aluno objetoAluno) throws Exception {

		// Campos Obrigatorios
		if (objetoAluno.getRm() == 0)
			return "RM é Obrigatorio";
		if (objetoAluno.getNome() == null)
			return "Nome é Obrigatorio";
		if (objetoAluno.getEmail() == null)
			return "Email é Obrigatorio";
		if (objetoAluno.getSenha() == null)
			return "Senha é Obrigatorio";
		if (objetoAluno.getCpf() == 0)
			return "CPF é Obrigatorio";
		if (objetoAluno.getCep() == 0)
			return "CEP é Obrigatorio";

		// PK RM_ALUNO DEVE SER UNICO
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.getAluno(objetoAluno.getRm());
		if (aluno.getRm() > 0)
			return "Aluno já cadastrado!";

		// Validar Nome Aluno, Characteres Especiais
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(objetoAluno.getNome());
		boolean charSpecial = m.find();
		if (charSpecial)
			return "Nome não pode ter caracteres especiais";
		if (objetoAluno.getNome().matches(".*\\d.*"))
			return "Nome não pode conter números";

		// Nome Deve Possuir Sobrenome
		if (objetoAluno.getNome().indexOf(" ") < 0)
			return "Nome deve conter sobrenome";

		// Email deve possuir @
		if (objetoAluno.getEmail().indexOf("@") < 0)
			return "E-mail inválido.";

		// Email deve possuir ".com"
		if (objetoAluno.getEmail().indexOf(".com") < 0)
			return "E-mail inválido.";

		// Qtd de Letras
		int qtdLetras = 0;
		for (int i = 0; i < objetoAluno.getNome().length(); i++)
			if (Character.isLetter(objetoAluno.getNome().charAt(i)))
				qtdLetras++;
		if (qtdLetras < 6 || qtdLetras > 50)
			return "Quantidade de Letras Inválida";

		// Qtd RM
		if (objetoAluno.getRm() < 5 || objetoAluno.getRm() > 5)
			return "RM deve possuir 5 digitos";

		// Qtd CPF
		if (objetoAluno.getCpf() < 11 || objetoAluno.getCpf() > 11)
			return "CPF deve possuir 11 digitos";

		// Qtd CEP
		if (objetoAluno.getCep() < 8 || objetoAluno.getCep() > 8)
			return "CEP deve possuir 8 digitos";

		// Se tudo certo
		alunoDAO.addAluno(objetoAluno);
		alunoDAO.close();
		return "Aluno Cadastrado!";
	}

	public String atualizaSenha(int cod, String newPass) throws Exception {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(newPass);
		boolean found = matcher.find();

		if (found)
			return "Senha não pode conter espaços";

		AlunoDAO alunoDAO = new AlunoDAO();
		int x = alunoDAO.updatePasswordAluno(cod, newPass);
		if (x == 0)
			return "Cadastro não localizado";
		else
			return "Senha Atualizada!";
	}

	public Aluno buscaAluno(int cod) throws Exception {
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno a = alunoDAO.getAluno(cod);
		if (a.getRm() == 0)
			return null;
		else {
			return a;
		}
	}

	public String loginAluno(int cod, String senha) throws Exception {
		AlunoDAO alunoDAO = new AlunoDAO();
		int a = alunoDAO.loginAluno(cod, senha);
		if (a == 0)
			return "Cadastro não localizado";
		else {
			return "Login Aceito!";
		}
	}

}