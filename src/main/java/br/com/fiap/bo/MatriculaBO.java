package br.com.fiap.bo;



import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Matricula;
import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.MatriculaDAO;

public class MatriculaBO {
public String novaMatricula (Matricula m) throws Exception{
	MatriculaDAO matriculaDAO = new MatriculaDAO();
	Matricula matricula = matriculaDAO.getMatricula(m.getAluno().getRm(), m.getDisciplina().getCodigo());
	//////// codigo disciplina 
	if (m.getDisciplina().getCodigo() < 0)
		return "Codigo deve ser positivo";

	if (m.getDisciplina().getCodigo() == 0)
		return "O codigo é obrigatorio";
	////////// rm aluno
	if (m.getAluno().getRm() == 0)
		return "RM é Obrigatorio";
	
//////////	
	AlunoDAO alunoDAO = new AlunoDAO();
	Aluno aluno = alunoDAO.getAluno(m.getAluno().getRm());
	if (aluno.getRm() > 0)
		return "Aluno já cadastrado!";
	
	
	matriculaDAO.addMatricula(matricula);
	matriculaDAO.close();
	return "Matricula Cadastrada";
	
}
	
	public String deletarMatricula (Matricula m) throws Exception{
		MatriculaDAO matriculaDAO = new MatriculaDAO();	
		
		matriculaDAO.deleteMatricula(m);
		matriculaDAO.close();
		return "Matricula deletada";
		
	}

}
