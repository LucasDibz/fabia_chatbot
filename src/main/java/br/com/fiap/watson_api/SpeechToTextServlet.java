package br.com.fiap.watson_api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;

@WebServlet(urlPatterns = "/stt")
public class SpeechToTextServlet extends HttpServlet {

	private static final long serialVersionUID = 7476959821119009111L;
	private String iamKey = "<apikey>";
	private String languageID = "<apikey>";
	private String acousticID = "<apikey>";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		byte[] buffer = new byte[1024 * 1024];

		// Need to fix String idioma
		String idioma = req.getParameter("idioma");
		System.out.println("stt - " + idioma);

		String modelo = "pt-BR_BroadbandModel";
		switch (idioma) {
		case "pt":
			modelo = "pt-BR_BroadbandModel";
			break;
		case "ar":
			modelo = "ar-AR_BroadbandModel";
			break;
		case "zh":
			modelo = "zh-CN_BroadbandModel";
			break;
		case "en":
			modelo = "en-US_BroadbandModel";
			break;
		case "fr":
			modelo = "fr-FR_BroadbandModel";
			break;
		case "de":
			modelo = "de-DE_BroadbandModel";
			break;
		case "ja":
			modelo = "ja-JP_BroadbandModel";
			break;
		case "ko":
			modelo = "ko-KR_BroadbandModel";
			break;
		case "es":
			modelo = "es-AR_BroadbandModel";
			break;
		}
		System.out.println("stt - " + modelo);

		InputStream is = req.getInputStream();
		File tempFile = File.createTempFile("speech-", ".wav");

		try (FileOutputStream os = new FileOutputStream(tempFile)) {
			int length;
			while ((length = is.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
		}

		IamOptions options = new IamOptions.Builder().apiKey(iamKey).build();

		SpeechToText service = new SpeechToText(options);

		RecognizeOptions recognizeOptions;

		if (idioma.equals("pt")) {
			recognizeOptions = new RecognizeOptions.Builder().audio(tempFile).contentType(HttpMediaType.AUDIO_WAV)
					.model("pt-BR_BroadbandModel").languageCustomizationId(languageID)
					.acousticCustomizationId(acousticID).build();
		} else {
			recognizeOptions = new RecognizeOptions.Builder().audio(tempFile).contentType(HttpMediaType.AUDIO_WAV)
					.model(modelo)
//					languageCustomizationId("<apikey>")
//					.acousticCustomizationId("<apikey>")
					.build();
		}

		SpeechRecognitionResults transcript = service.recognize(recognizeOptions).execute().getResult();

		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(transcript.getResults()));

	}
}
