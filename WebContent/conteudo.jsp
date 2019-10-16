<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>Cursos de Nivelamento</title>
<link rel="icon" href="Imagens/icon.png">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/conteudo.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/c34d53500c.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<nav class="navbar navbar-expand-md my-nav">
		<a class="navbar-brand h1 mb-0" href="#">FABIA</a>

		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#collapse_target" type="button" name="button">
			<span class="navbar-toggler-icon"><i class="fa fa-bars"
				aria-hidden="true"></i></span>
		</button>

		<div class="collapse navbar-collapse" id="collapse_target">
			<ul class="navbar-nav mr-auto">
				<li class="divisor" role="separator"></li>
				<li class="nav-item">
				<a class="nav-link" href="conteudo.jsp">Home</a>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="chat.jsp">Chatbot</a>
				</li>
			</ul>

			<ul class="navbar-nav ml-auto">
				<!--         <li class="nav-item"> -->
				<!--           <a class="nav-link" href="admin.jsp">Admin</a> -->
				<!--         </li> -->
				<li class="nav-item">
				<form action="UserServlet" method="post">
					<input type="hidden" value="Exibir" name="action">
					<input type="hidden" value=<%= session.getAttribute("rm") %> name="rm">
					<button class="dados" type="submit" name="button"><i class="fas fa-user"></i>Meus Dados</button>
				</form>									
				<li class="divisor" role="separator"></li>
				<li class="nav-item">
					<a class="nav-link" href="login.jsp">Sair</a>
				</li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<div class="container">
		<div class="titulo">
			<h1 class="display-4">Cursos de Nivelamento</h1>
		</div>
		<div class="cursos">
			<h3>Português</h3>
			<h3>Matemática</h3>
			<h3 class="active">Algoritmo</h3>
		</div>
		<ul class="lista">
			<li><a href="cap1.jsp">Capítulo 1 - Principios da programação</li>
			<li><a href="cap2.jsp">Capítulo 2 - Tomada de Decisão</li>
			<li><a href="cap3.jsp">Capítulo 3 - Estruturas de Repetição</li>
			<li><a href="cap4.jsp">Capítulo 4 - Vetores e Matrizes</li>
			<li><a href="cap5.jsp">Capítulo 5 - Análise Algorítmica</li>
			<li><a href="cap6.jsp">Capítulo 6 - Ordenação de Vetores</li>
			<li><a href="cap7.jsp">Capítulo 7 - Busca</li>
		</ul>
	</div>

	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
					<p class="lead">Redes Sociais</p>
					<div class="social">
						<a href="https://pt-br.facebook.com/fiap/"><i
							class="fab fa-facebook-square"></i></a> <a
							href="https://twitter.com/fiap"><i
							class="fab fa-twitter-square"></i></a> <a
							href="https://www.instagram.com/fiapoficial/?hl=pt-br"><i
							class="fab fa-instagram"></i></a>
					</div>
				</div>
				<div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
					<p class="lead">Localização</p>
					<p class="address">Aclimação, Av. Lins de Vasconcelos, 1222 e
						1264</p>
					<div class="local">
						<p>
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3656.842492309439!2d-46.62541608533719!3d-23.574099767947246!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce597abf1a28ff%3A0x1b02a58f85e6395e!2sFIAP!5e0!3m2!1spt-BR!2sbr!4v1570590966601!5m2!1spt-BR!2sbr"
								width="200" height="200" frameborder="0" style="border: 0;"
								allowfullscreen=""></iframe>
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>
