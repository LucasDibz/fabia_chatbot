package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.beans.Progressao;
import br.com.fiap.conexao.Conexao;

public class ProgressaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ProgressaoDAO ( ) throws Exception{
		con = Conexao.getConnection();
	}
	public void close () throws Exception{
		con.close();
	}
	public int addProgressao (Progressao p ) throws Exception{
		stmt = con.prepareStatement(""
				+ "INSERT INTO T_CHATBOT_PROGRESSAO (CD_CONTEUDO,NR_RM,CD_DISCIPLINA,ST_STATUS,ST_PROGRESSAO) VALUES(?,?,?,?,? ) ");
		stmt.setInt(1, p.getConteudo().getCodigo());
		stmt.setInt(2, p.getAluno().getRm());
		stmt.setInt(3, p.getDisciplina().getCodigo());
		stmt.setInt(4, p.getStatus());
		stmt.setInt(5, p.getProgressao());
		
		return stmt.executeUpdate();	
	}
	public int deleteProgressao (Progressao p) throws	Exception{
		stmt = con.prepareStatement("DELETE FROM T_CHATBOT_PROGRESSAO WHERE NR_RM = ?  ");
		stmt.setInt(1, p.getAluno().getRm());
		return stmt.executeUpdate();
	}
	public int updateProgressao ( int progressao, int rm, int cd_conteudo) throws Exception{
		stmt = con.prepareStatement("UPDATE T_CHATBOT_PROGRESSAO SET ST_PROGRESSAO = ? WHERE NR_RM = ? AND CD_CONTEUDO = ? ");
		stmt.setInt(1, progressao);
		stmt.setInt(2, rm);
		stmt.setInt(3, cd_conteudo);
		
	return	stmt.executeUpdate();		
	}
	public int updateStatus (int status , int cd_conteudo, int cd_disciplina) throws Exception{
		stmt = con.prepareStatement("UPDATE T_CHATBOT_PROGRESSAO SET ST_STATUS = ? WHERE CD_DISCIPLINA = ? AND CD_CONTEUDO = ? ");
		stmt.setInt(1, status);
		stmt.setInt(2, cd_disciplina);
		stmt.setInt(3, cd_conteudo);
		return stmt.executeUpdate();
	}
	public Progressao getProgressao (int cd_disciplina  ,int cd_conteudo, int rm) throws Exception{
		stmt = con.prepareStatement("SELECT * FROM  T_CHATBOT_PROGRESSAO WHERE CD_DISCIPLINA = ? AND CD_CONTEUDO = ? AND NR_RM =? ");
		stmt.setInt(1, cd_disciplina);
		stmt.setInt(2, cd_conteudo);
		stmt.setInt(3, rm);
		stmt.executeQuery();
		if(rs.next()) {
			Progressao progressaoObj = new Progressao();
			progressaoObj.setStatus(rs.getInt("ST_STATUS"));
			progressaoObj.setProgressao(rs.getInt("ST_PROGRESSAO"));
			
			
			AlunoDAO daoaluno = new AlunoDAO();
			Aluno alun = daoaluno.getAluno(rs.getInt("NR_RM"));
			progressaoObj.setAluno(alun);
			daoaluno.close();
			
			DisciplinaDAO daoDisc = new DisciplinaDAO();
			Disciplina disc = daoDisc.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			progressaoObj.setDisciplina(disc);
			daoDisc.close();
			
			ConteudoDAO daoCont = new ConteudoDAO();
			Conteudo cont = daoCont.getConteudo(rs.getInt("CD_CONTEUDO"));
			progressaoObj.setConteudo(cont);
			daoCont.close();
			
			return progressaoObj;
		}
			else {
				return new Progressao();
			}
			
		
	}
	
}
