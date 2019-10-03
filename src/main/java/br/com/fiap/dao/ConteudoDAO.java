package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Conteudo;
import br.com.fiap.conexao.Conexao;

public class ConteudoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public ConteudoDAO() throws Exception {
		con = Conexao.getConnection();
	}

	public void close() throws Exception {
		con.close();
	}

	public int addConteudo(Conteudo c) throws Exception {
		stmt = con.prepareStatement(
				"INSERT INTO T_CHATBOT_CONTEUDO(CD_CONTEUDO,CD_DISCIPLINA,DS_TITULO,LC_CONTEUDO) VALUES (?,?,?,?)");
		stmt.setInt(1, c.getCodigo());
		stmt.setInt(2, c.getCd_disciplina());
		stmt.setString(3, c.getTitulo());
		stmt.setString(4, c.getLocal());
		return stmt.executeUpdate();
	}

	public int deleteConteudo(Conteudo c) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_CHATBOT_CONTEUDO WHERE CD_CONTEUDO = ? ");
		stmt.setInt(1, c.getCodigo());
		return stmt.executeUpdate();
	}

	public int updateConteudo(int codigo, String local) throws Exception {
		stmt = con.prepareStatement("UPDATE T_CHATBOT_CONTEUDO SET LC_CONTEUDO = ? WHERE CD_CONTEUDO = ? ");
		stmt.setString(1, local);
		stmt.setInt(2, codigo);
		return stmt.executeUpdate();
	}

	public int updateTitulo(int codigo, String titulo) throws Exception {
		stmt = con.prepareStatement("UPDATE T_CHATBOT_CONTEUDO SET DS_TITULO = ? WHERE CD_CONTEUDO = ? ");
		stmt.setString(1, titulo);
		stmt.setInt(2, codigo);
		return stmt.executeUpdate();
	}

	public Conteudo getConteudo(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_CHATBOT_CONTEUDO WHERE CD_CONTEUDO = ?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Conteudo(rs.getInt("CD_CONTEUDO"), rs.getInt("CD_DISCIPLINA"), rs.getString("DS_TITULO"),
					rs.getString("LC_CONTEUDO"));
		} else {
			return new Conteudo();
		}
	}
}
