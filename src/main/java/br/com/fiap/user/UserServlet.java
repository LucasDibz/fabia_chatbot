package br.com.fiap.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.beans.Aluno;
import br.com.fiap.bo.AlunoBO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		System.out.println("ação = " + action);
		String retorno = "";

		switch (action) {
		case "Cadastrar":
			try {
				cadastrar(request);
//				listar(request);
				retorno = "login.jsp";
			} catch (Exception e) {
			}
			break;
		case "Exibir":
			try {
				buscaAluno(request);
				retorno = "usuario.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		}

		request.getRequestDispatcher(retorno).forward(request, response);

	}

	private void cadastrar(HttpServletRequest request) throws Exception {
		int rm = Integer.parseInt(request.getParameter("rm"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		int telefone = Integer.parseInt(request.getParameter("telefone"));
		int cpf = Integer.parseInt(request.getParameter("cpf"));
		int cep = Integer.parseInt(request.getParameter("cep"));
		String senha = request.getParameter("senha");

		Aluno aluno = new Aluno(rm, nome, email, senha, telefone, cpf, cep);
		AlunoBO alunoBO = new AlunoBO();
		alunoBO.novoAluno(aluno);

	}

	private void buscaAluno(HttpServletRequest request) throws Exception {
		AlunoBO bo = new AlunoBO();
		int rm = Integer.parseInt(request.getParameter("rm"));
		System.out.println("rm = " + rm);
		Aluno aluno = bo.buscaAluno(rm);
		request.setAttribute("aluno", aluno);
	}

}
