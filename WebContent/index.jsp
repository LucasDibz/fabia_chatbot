<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IBM Watson w/ Java SDK</title>
<link rel="icon" href="favicon.png">
<link rel="stylesheet" type="text/css" href="style/main.css" />
</head>
<body>
	<section class="container">
		<h2 class="title">Chatbot Example w/ Watson API and Java</h2>
		<div class="chat-container"></div>
		<input type="text" id="question" name="question" class="field"
			placeholder="Type your question or message to convert in audio" />
		<div class="controls">
			<button id="sendQuestion">Send</button>
			<button id="getVoiceButton">Get Voice</button>
			<button id="recordButton">Record</button>
			<button id="pauseButton" disabled>Pause</button>
			<button id="stopButton" disabled>Stop</button>
			<select id="idioma">
				<option value="pt" selected="selected">Português</option>
				<option value="en">Inglês</option>
				<option value="ar">Árabe</option>
				<option value="bg">Búlgaro</option>
				<option value="ca">Catalão</option>
				<option value="zh">Chinês Simplificado</option>
				<option value="zh-TW">Chinês Tradicional</option>
				<option value="hr">Croata</option>
				<option value="cs">Tcheco</option>
				<option value="da">Dinamarquês</option>
				<option value="nl">Holandês</option>
				<option value="et">Estoniano</option>
				<option value="fi">Finlandês</option>
				<option value="fr">Francês</option>
				<option value="de">Alemão</option>
				<option value="el">Grego</option>
				<option value="he">Hebraico</option>
				<option value="hi">Hindi</option>
				<option value="hi">Hindi</option>
				<option value="hu">Húngaro</option>
				<option value="hu">Húngaro</option>
				<option value="it">Italian</option>
				<option value="ja">Japonês</option>
				<option value="ko">Koreano</option>
				<option value="nb">Norueguês</option>
				<option value="pl">Polonês</option>
				<option value="ro">Romeno</option>
				<option value="ru">Russo</option>
				<option value="sk">Eslovaco</option>
				<option value="sl">Esloveno</option>
				<option value="es">Espanhol</option>
				<option value="sv">Sueco</option>
				<option value="tr">Turco</option>		
			</select>
		</div>
	</section>
	<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
	<!-- Para a versão dois utilizar o script main.js -->
	<script type="text/javascript" src="scripts/assistant.js"></script>
	<script type="text/javascript" src="scripts/tts.js"></script>
	<script type="text/javascript" src="scripts/stt.js"></script>
</body>
</html>