<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
						<label for="nome">RM</label><br> <input type="text" name="rm"
							placeholder="Enter Username">
					</div>
					<div class="form-group">
						<label for="senha">Senha</label><br> <input type="password"
							name="senha" placeholder="Enter password">
					</div>
					<br><a href="cadastro.html">Create new account</a><br><br>
					<input type="submit" value="Login" class="btn btn-block">
<!-- 					<button type="submit" name="button" class="btn btn-block"><a href="curso.html">Login</a></button> -->
					<br>
				</form>
				<span><%=msg %></span>
			</div>
		</div>
	</div>

</body>
</html>