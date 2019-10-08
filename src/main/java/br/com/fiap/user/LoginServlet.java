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

		int rm = Integer.parseInt(request.getParameter("rm"));
		String senha = request.getParameter("senha");

		session = request.getSession();

		AlunoBO aluno = new AlunoBO();
		try {
			aluno.loginAluno(rm, senha);
			session.setAttribute("rm", rm);
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			request.setAttribute("msg", "Usuário ou Senha inválidos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
