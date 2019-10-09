package br.com.fiap.watson_api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;

@WebServlet(urlPatterns = "/traduz")
public class Translator extends HttpServlet {

	private Context context;
	private static final long serialVersionUID = -8716683257301345455L;
	// Keys
	String iamKey = "<apikey>";
	String skillKey = "<apikey>";
	String translatorKey = "<apikey>";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Keys

		String idioma = req.getParameter("idioma");
		System.out.println(idioma);

		String msg = req.getParameter("question");
		if (idioma.equals("en")) {
			msg = translateMe(msg, idioma);
			System.out.println("msg indo pro bot = " + msg);
		} else {
			msg = translateMe(msg, idioma);
			msg = translateMe(msg, "en");
			System.out.println("msg indo pro bot = " + msg);
		}

		if (msg.isEmpty())
			this.context = null;

		MessageResponse response = this.assistantAPICall(msg);

		resp.setContentType("application/json");
		if (idioma.equals("en"))
			resp.getWriter().write(translateBot(new Gson().toJson(response.getOutput().getText()), idioma));
		else {
			String respostaBot = response.getOutput().getText().get(0);
			System.out.println("RESPOSTA 64 - " + respostaBot);
			respostaBot = translateBot(respostaBot, "en");
			respostaBot = translateBot(respostaBot, idioma);
			System.out.println("REPOSTA 67 - " + respostaBot);

			resp.getWriter().write(new Gson().toJson(respostaBot));
			System.out.println("JSON BOT - " + new Gson().toJson(respostaBot));
		}

	}

	private String translateMe(String msg, String idioma) {
		IamOptions options = new IamOptions.Builder().apiKey(translatorKey).build();

		LanguageTranslator languageTranslator = new LanguageTranslator("2018-05-01", options);

		TranslateOptions translateOptions;
		TranslationResult result = null;

		if (idioma.equals("en")) {
			translateOptions = new TranslateOptions.Builder().addText(msg).modelId(idioma + "-pt").build();
			result = languageTranslator.translate(translateOptions).execute().getResult();
			System.out.println("translator linha 56 - " + result.getTranslations().get(0).getTranslationOutput());

		}

		else {
			translateOptions = new TranslateOptions.Builder().addText(msg).modelId(idioma + "-en").build();

//			translateMe(estrangeiro, "en");

			result = languageTranslator.translate(translateOptions).execute().getResult();
		}

		System.out.println("linha 70 - " + result.getTranslations().get(0).getTranslationOutput());

		return result.getTranslations().get(0).getTranslationOutput();
	}

	private String translateBot(String msg, String idioma) {
		IamOptions options = new IamOptions.Builder().apiKey(translatorKey).build();

		LanguageTranslator languageTranslator = new LanguageTranslator("2018-05-01", options);

		TranslateOptions translateOptions;
		TranslationResult result = null;

		if (idioma.equals("en")) {
			translateOptions = new TranslateOptions.Builder().addText(msg).modelId("pt-" + idioma).build();

			result = languageTranslator.translate(translateOptions).execute().getResult();

		} else {
			translateOptions = new TranslateOptions.Builder().addText(msg).modelId("en-" + idioma).build();

			result = languageTranslator.translate(translateOptions).execute().getResult();
		}

		return result.getTranslations().get(0).getTranslationOutput();
	}

	private MessageResponse assistantAPICall(String msg) {

		// Configuração de autenticação do serviço
		IamOptions options = new IamOptions.Builder().apiKey(iamKey).build();

		// Criando o objeto do serviço desejado
		Assistant service = new Assistant("2018-02-16", options);
		String workspaceId = skillKey;

		// Preparando a mensagem de envio
		MessageInput input = new MessageInput();
		input.setText(msg);

		// Configurando os parametros para o Watson
		MessageOptions messageOptions = new MessageOptions.Builder().workspaceId(workspaceId).input(input)
				.context(this.context).build();

		// Conectando com o Assistant e recebendo a resposta dele
		MessageResponse response = service.message(messageOptions).execute().getResult();

		this.context = response.getContext();

		// Verifica se as variaveis de contexto foram totalmente preenchidas
		// Quando o nó de dialogo for completo reinicia o contexto
		if (response.getContext().getSystem().getProperties().get("branch_exited") != null)
			if ((boolean) response.getContext().getSystem().getProperties().get("branch_exited") && response
					.getContext().getSystem().getProperties().get("branch_exited_reason").equals("completed"))
				this.context = null;

		return response;
	}

}
