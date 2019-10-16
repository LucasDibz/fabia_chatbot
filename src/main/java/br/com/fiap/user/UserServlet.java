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

	String retorno = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		System.out.println("ação = " + action);

		switch (action) {
		case "Cadastrar":
			try {
				String msg = "";
				cadastrar(request, retorno, msg);
				request.setAttribute("msg", msg);
			} catch (Exception e) {
				System.out.println("Cadastrar deu ruim");
				e.printStackTrace();
			}
			break;
		case "Exibir":
			try {
				buscaAluno(request);
				retorno = "usuario.jsp";
			} catch (Exception e) {
				System.out.println("Exibir deu ruim");
				e.printStackTrace();
			}
			break;

		}

		System.out.println("retorno l50 = " + retorno);
		request.getRequestDispatcher(retorno).forward(request, response);

	}

	private void cadastrar(HttpServletRequest request, String retorno, String msg) throws Exception {
		int rm = Integer.parseInt(request.getParameter("rm"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		long telefone = Long.parseLong(request.getParameter("telefone"));
		long cpf = Long.parseLong(request.getParameter("cpf"));
		int cep = Integer.parseInt(request.getParameter("cep"));
		String senha = request.getParameter("senha");

		System.out.println(rm);
		System.out.println(nome);
		System.out.println(email);
		System.out.println(telefone);
		System.out.println(cpf);
		System.out.println(cep);
		System.out.println(senha);

		Aluno aluno = new Aluno(rm, nome, email, senha, telefone, cpf, cep);
		AlunoBO alunoBO = new AlunoBO();
		msg = alunoBO.novoAluno(aluno);
		if (msg.equals("Aluno Cadastrado!"))
			retorno = "login.jsp";
		else
			retorno = "cadastro.jsp";

		System.out.println("retorno = " + retorno);
		System.out.println(msg);

	}

	private void buscaAluno(HttpServletRequest request) throws Exception {
		AlunoBO bo = new AlunoBO();
		int rm = Integer.parseInt(request.getParameter("rm"));
		System.out.println("rm = " + rm);
		Aluno aluno = bo.buscaAluno(rm);
		request.setAttribute("aluno", aluno);
	}

}
