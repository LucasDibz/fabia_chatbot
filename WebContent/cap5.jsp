<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="pt-br" dir="ltr">
<head>
<meta charset="utf-8">
<title>Cap 5 - Análise Algorítmica</title>
<link rel="icon" href="Imagens/icon.png">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/capitulo.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/c34d53500c.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<div id="msg" class="container">
		<div id="msg-top" style="padding: 10px 0px;">
			<p class="titlechat">Fabia - Chatbot</p>
		</div>
		<div class="chat-container"></div>
		<form class="form-container" action="" method="post">
			<input type="text" id="question" name="question"
				placeholder="Digite sua mensagem..." class="form" required />
			<div class="btn-group controls">
				<select class="botao" id="idioma">
					<option value="pt" selected="selected">Português</option>
					<option value="en">Inglês</option>
					<option value="de">Alemão</option>
					<option value="ar">Árabe</option>
					<option value="bg">Búlgaro</option>
					<option value="ca">Catalão</option>
					<option value="zh">Chinês Simplificado</option>
					<option value="zh-TW">Chinês Tradicional</option>
					<option value="hr">Croata</option>
					<option value="da">Dinamarquês</option>
					<option value="sk">Eslovaco</option>
					<option value="sl">Esloveno</option>
					<option value="es">Espanhol</option>
					<option value="et">Estoniano</option>
					<option value="fi">Finlandês</option>
					<option value="fr">Francês</option>
					<option value="el">Grego</option>
					<option value="he">Hebraico</option>
					<option value="hi">Hindi</option>
					<option value="nl">Holandês</option>
					<option value="hu">Húngaro</option>
					<option value="it">Italiano</option>
					<option value="ja">Japonês</option>
					<option value="ko">Koreano</option>
					<option value="nb">Norueguês</option>
					<option value="pl">Polonês</option>
					<option value="ro">Romeno</option>
					<option value="ru">Russo</option>
					<option value="sv">Sueco</option>
					<option value="cs">Tcheco</option>
					<option value="tr">Turco</option>
				</select>
				<button id="sendQuestion" type="button" name="button"
					class="botao bt">Send</button>
			</div>
		</form>
	</div>

	<script type="text/javascript" src="scripts/assistant.js"></script>
	<script type="text/javascript" src="scripts/tts.js"></script>
	<script type="text/javascript" src="scripts/stt.js"></script>

	<div id="home">
		<div class="text">
			<h1>Algoritmos</h1>
			<h3>ANÁLISE ALGORÍTMICA</h3>
			<a class="btn btn-outline-light btn-lg" href="chat.jsp">CHATBOT</a>
		</div>
	</div>

	<nav class="navbar navbar-expand-md sticky-top my-nav">
		<a class="navbar-brand h1 mb-0" href="#">FABIA</a>

		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#collapse_target" type="button" name="button">
			<span class="navbar-toggler-icon"><i class="fa fa-bars"
				aria-hidden="true"></i></span></span>
		</button>

		<div class="collapse navbar-collapse" id="collapse_target">
			<ul class="navbar-nav mr-auto">
				<li class="divisor" role="separator"></li>
				<li class="nav-item"><a class="nav-link" href="conteudo.jsp">Home</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown"
					data-target="#dropdown_target" href="#">Capítulos</a> <span
					class="caret"></span>

					<div class="dropdown-menu" aria-labelledby="dropdown_target">
						<ul class="navbar-nav">
							<a class="dropdown-item" href="cap1.jsp">Capitulo 1</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cap2.jsp">Capitulo 2</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cap3.jsp">Capitulo 3</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cap4.jsp">Capitulo 4</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cap6.jsp">Capitulo 6</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="cap7.jsp">Capitulo 7</a>
						</ul>
					</div></li>
			</ul>

			<ul class="navbar-nav ml-auto">
				<!-- <li class="nav-item">
        <a class="nav-link" href="admin.jsp">Admin</a>
      </li> -->
				<li class="nav-item">
					<form action="UserServlet" method="post">
						<input type="hidden" value="Exibir" name="action"> <input
							type="hidden" value=<%=session.getAttribute("rm")%> name="rm">
						<button class="dados" type="submit" name="button">
							<i class="fas fa-user"></i>Meus Dados
						</button>
					</form>
				<li class="divisor" role="separator"></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Sair</a>
				</li>
			</ul>
		</div>
		</div>

	</nav>

	<br>
	<br>
	<br>
	<div class="container">
		<h1 class="display-4">Análise Algorítima</h1>
		<br>
		<br>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<div class="box">
					<iframe src="pdf/cap5.pdf" width="850" height="800"
						style="border: none;"></iframe>
				</div>
			</div>
		</div>
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

<script type="text/javascript">
	$(document).ready(function() {
		var c = 1;
		$("#msg-top").click(function() {
			c++;
			if (c % 2 == 0)
				$("#msg").animate({
					bottom : "0px"
				}, 500);
			else
				$("#msg").animate({
					bottom : "-350px"
				}, 500);
		});
	});
</script>
</html>
