package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Aluno;
import conexao.Conexao;

public class AlunoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	// RENOMEAR TABELAS

	public AlunoDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public void close() throws Exception {
		con.close();
	}

	public int addAluno(Aluno a) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_CHATBOT_ALUNO (RM_ALUNO, NM_ALUNO, SN_ALUNO) VALUES (?,?,?)");
		stmt.setInt(1, a.getCodigo());
		stmt.setString(2, a.getNome());
		stmt.setString(3, a.getSenha());
		return stmt.executeUpdate();
	}

	public int updatePasswordAluno(int cod, String newPass) throws Exception {
		stmt = con.prepareStatement("UPDATE T_CHATBOT_ALUNO SET SN_ALUNO=? WHERE CD_ALUNO=?");
		stmt.setInt(1, cod);
		stmt.setString(2, newPass);
		return stmt.executeUpdate();
	}

	public int deleteAluno(int cod) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_CHATBOT_ALUNO WHERE CD_ALUNO=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}

	public Aluno getAluno(int cod) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_CHATBOT_ALUNO WHERE CD_ALUNO=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Aluno(rs.getInt("CD_ALUNO"), rs.getString("NM_ALUNO"), rs.getString("SN_ALUNO"));
		} else
			return new Aluno();
	}

	public int loginAluno(int cod, String senha) throws Exception {
		stmt = con.prepareStatement("SELECT FROM T_CHATBOT_ALUNO WHERE CD_ALUNO=? AND SN_ALUNO=?");
		stmt.setInt(1, cod);
		stmt.setString(2, senha);
		return stmt.executeUpdate();
	}
}
