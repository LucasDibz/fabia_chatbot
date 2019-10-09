window.onload = function() {
//	callBot("");
}

function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

function createMessage(message, type) {
	var chat = document.querySelector(".chat-container");
	var div = createDiv(message, type);
	chat.appendChild(div);
	scrollDivDown(chat);
}

function createDiv(text, type) {
	var div = document.createElement("div");
	div.classList.add("chat");
	div.classList.add(type);
	div.textContent = text;
	return div;
}

var btnSendQuestion = document.querySelector("#sendQuestion");
btnSendQuestion.addEventListener("click", function(event) {
	event.preventDefault();
	var question = document.querySelector("#question");
	createMessage(question.value, "me");
	callBot(question.value);
	question.value = "";
});

function callBot(msg) {
	var idioma = document.querySelector("#idioma").value;
	console.log(idioma);
	var xhr = new XMLHttpRequest();
	if (idioma == "pt") {
		xhr.open("POST", "v1", true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded; charset=utf-8");
		xhr.addEventListener("load", function() {
			if (xhr.status == 200) {
				// Codigo de sucesso
				var respostas = JSON.parse(xhr.responseText);
				respostas.forEach(function(resposta) {
					console.log(resposta);
					if (!(resposta === null) && !(resposta == "")){
						createMessage(resposta, "bot");
						sendMessageToVoice(resposta, "bot");
					}
				});
			} else {
				// Codigo de deu ruim!
				console.log(xhr.status);
				console.log(xhr.responseText);
			}
		});
	}
	else {
		xhr.open("POST", "traduz", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
		xhr.addEventListener("load", function() {
			if(xhr.status == 200) {
				// Codigo de sucesso
				var resposta = JSON.parse(xhr.responseText);
					console.log(resposta);
					if(!(resposta === null) && !(resposta == "")){
						createMessage(resposta, "bot");
						sendMessageToVoice(resposta, "bot");
					}
			}else{
				// Codigo de deu ruim!
				console.log(xhr.status);
				console.log(xhr.responseText);
			}
		});
	}
	var data = "question=" + msg + "&idioma=" + idioma;
	xhr.send(data);
}
