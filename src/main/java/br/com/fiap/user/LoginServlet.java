package br.com.fiap.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bo.AlunoBO;

@WebServlet("/Logar")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametro = request.getParameter("acao");

		if (parametro.equals("deslogar")) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rm = 0;
		try {
			rm = Integer.parseInt(request.getParameter("rm"));
		} catch (Exception e) {
			System.out.println("linha 39 - " + rm);
			request.setAttribute("msg", "Usuário Inválido");
		}

		String senha = request.getParameter("senha");

		AlunoBO aluno = new AlunoBO();
		session = request.getSession();

		try {
			if (aluno.loginAluno(rm, senha) > 0) {
				System.out.println("LOGUEI");
				System.out.println("linha 49 RM = " + rm);
				session.setAttribute("rm", rm);
				response.sendRedirect("conteudo.html");
			} else {
				System.out.println("linha 56 rm = " + rm);
				request.setAttribute("msg", "Usuário ou Senha inválidos");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("DEU RUIM");
			e.printStackTrace();
			request.setAttribute("msg", "Usuário ou Senha inválidos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
