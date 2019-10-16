<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="br.com.fiap.conexao.*"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>Login</title>
<link rel="icon" href="Imagens/icon.png">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/c34d53500c.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<%
		String msg;
		if (request.getAttribute("msg") != null) {
			msg = (String) request.getAttribute("msg");
		} else
			msg = "";
	%>

	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<form class="form-container" action="Logar" method="post">
					<h2>Login</h2>
					<div class="form-group">
						<label for="rm">RM</label><br> <input type="text" name="rm"
							placeholder="Enter Username">
					</div>
					<div class="form-group">
						<label for="senha">Senha</label><br> <input type="password"
							name="senha" placeholder="Enter password">
					</div>
					<span class="alert"><%=msg%></span><br><br>
					<a href="cadastro.jsp">Create new account</a><br> <br>
					<button type="submit" name="button" class="btn btn-block"
						value="Logar">Login</button>
					<br>
				</form>				
			</div>
		</div>
	</div>

</body>
</html>

