package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.beans.Matricula;
import br.com.fiap.conexao.Conexao;

public class MatriculaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public MatriculaDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public void close() throws Exception {
		con.close();
	}

	public int addMatricula(Matricula m) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO T_CHATBOT_MATRICULA(DT_INICIO,DT_TERMINO,NR_RM,CD_DISCIPLINA)VALUES(?,?,?,?)");
		stmt.setDate(1, m.getInicio());
		stmt.setDate(2, m.getTermino());
		stmt.setInt(3, m.getAluno().getRm());
		stmt.setInt(4, m.getDisciplina().getCodigo());
		return stmt.executeUpdate();
	}

	public int deleteMatricula(Matricula m) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_CHATBOT_MATRICULA WHERE NR_RM = ?");
		stmt.setInt(1, m.getAluno().getRm());
		return stmt.executeUpdate();
	}

	public int updateDataTermino(int rm, int codDisc, Date termino) throws Exception {
		stmt = con.prepareStatement(
				"UPDATE T_CHATBOT_MATRICULA SET DT_TERMINO = ? WHERE NR_RM = ? AND CD_DISCIPLINA = ?");
		stmt.setDate(1, termino);
		stmt.setInt(2, rm);
		stmt.setInt(3, codDisc);
		return stmt.executeUpdate();
	}

	public Matricula getMatricula(int rm, int disciplina) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_CHATBOT_MATRICULA  WHERE NR_RM = ? AND CD_DISCIPLINA =?  ");
		stmt.setInt(1, rm);
		stmt.setInt(1, disciplina);
		rs = stmt.executeQuery();
		if (rs.next()) {
			Matricula objeto = new Matricula();
			objeto.setInicio(rs.getDate("DT_INICIO"));
			objeto.setTermino(rs.getDate("DT_TERMINO"));

			AlunoDAO daoaluno = new AlunoDAO();
			Aluno alun = daoaluno.getAluno(rs.getInt("NR_RM"));
			objeto.setAluno(alun);
			daoaluno.close();

			DisciplinaDAO dao = new DisciplinaDAO();
			Disciplina disc = dao.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			objeto.setDisciplina(disc);
			dao.close();
			return objeto;
		} else {
			return new Matricula();
		}
	}
}