package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.conexao.Conexao;

public class AlunoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public AlunoDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public void close() throws Exception {
		con.close();
	}

	public int addAluno(Aluno a) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO T_CHATBOT_ALUNO (NR_RM, NM_ALUNO, DS_EMAIL, SN_ALUNO, NR_TELEFONE, NR_CPF, NR_CEP) VALUES (?,?,?,?,?,?,?)");
		stmt.setInt(1, a.getRm());
		stmt.setString(2, a.getNome());
		stmt.setString(3, a.getEmail());
		stmt.setString(4, a.getSenha());
		stmt.setInt(5, a.getTelefone());
		stmt.setInt(6, a.getCpf());
		stmt.setInt(7, a.getCep());
		return stmt.executeUpdate();
	}

	public int updatePasswordAluno(int cod, String newPass) throws Exception {
		stmt = con.prepareStatement("UPDATE T_CHATBOT_ALUNO SET SN_ALUNO=? WHERE NR_RM=?");
		stmt.setInt(1, cod);
		stmt.setString(2, newPass);
		return stmt.executeUpdate();
	}

	public int deleteAluno(int cod) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_CHATBOT_ALUNO WHERE NR_RM=?");
		stmt.setInt(1, cod);
		return stmt.executeUpdate();
	}

	public Aluno getAluno(int cod) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_CHATBOT_ALUNO WHERE NR_RM=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Aluno(rs.getInt("NR_RM"), rs.getString("NM_ALUNO"), rs.getString("DS_EMAIL"),
					rs.getString("SN_ALUNO"), rs.getInt("NR_TELEFONE"), rs.getInt("NR_CPF"), rs.getInt("NR_CEP"));
		} else
			return new Aluno();
	}

	public int loginAluno(int cod, String senha) throws Exception {
		stmt = con.prepareStatement("SELECT NR_RM FROM T_CHATBOT_ALUNO WHERE NR_RM=? AND SN_ALUNO=?");
		stmt.setInt(1, cod);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("NR_RM");
		} else
			return 0;
	}
}
