package bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beans.Aluno;
import dao.AlunoDAO;

public class AlunoBO {
	public String novoAluno(Aluno objetoAluno) throws Exception {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(objetoAluno.getNome());
		boolean charSpecial = m.find();

		if (charSpecial)
			return "Nome não pode ter caracteres especiais";
		if (objetoAluno.getNome().matches(".*\\d.*"))
			return "Nome não pode conter números";

		// PK RM_ALUNO DEVE SER UNICO
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.getAluno(objetoAluno.getCodigo());
		if (aluno.getCodigo() > 0)
			return "Aluno já cadastrado!";

		alunoDAO.addAluno(objetoAluno);
		alunoDAO.close();
		return "Aluno Cadastrado!";
	}
}
