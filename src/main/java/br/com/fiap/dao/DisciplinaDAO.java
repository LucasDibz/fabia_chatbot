package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Disciplina;
import br.com.fiap.conexao.Conexao;

public class DisciplinaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public DisciplinaDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public void close() throws Exception {
		con.close();
	}

	public int addDisciplina(Disciplina d) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO T_CHATBOT_DISCIPLINA(CD_DISCIPLINA,NM_DISCIPLINA,ST_STATUS) VALUES(?,?,?)");
		stmt.setInt(1, d.getCodigo());
		stmt.setString(2, d.getNome());
		stmt.setInt(3, d.getStatus());
		return stmt.executeUpdate();
	}

	public int updateStatus(int codigo, int status) throws Exception {
		stmt = con.prepareStatement("UPDATE T_CHATBOT_DISCIPLINA SET ST_STATUS = ? WHERE CD_DISCIPLINA = ?");
		stmt.setInt(1, status);
		stmt.setInt(2, codigo);
		return stmt.executeUpdate();
	}

	public int deleteDisciplina(int codigo) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_CHATBOT_DISCIPLINA WHERE CD_DISCIPLINA = ?");
		stmt.setInt(1, codigo);
		return stmt.executeUpdate();
	}

	public Disciplina getDisciplina(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_CHATBOT_DISCIPLINA WHERE CD_DISCIPLINA = ?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Disciplina(rs.getInt("CD_DISCIPLINA"), rs.getString("NM_DISCIPLINA"), rs.getInt("ST_STATUS"));

		} else {
			return new Disciplina();
		}

	}

}