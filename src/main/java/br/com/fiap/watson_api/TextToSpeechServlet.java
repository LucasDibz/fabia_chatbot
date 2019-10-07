package br.com.fiap.watson_api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.text_to_speech.v1.util.WaveUtils;

@WebServlet(urlPatterns = "/tts")
public class TextToSpeechServlet extends HttpServlet {

	private static final long serialVersionUID = 1553566979042668816L;
	// Keys
	private String iamKey = "<apikey>";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String msg = req.getParameter("question");
		String idioma = req.getParameter("idioma");
		System.out.println("tts - " + idioma);
		String modelo = "en-US_AllisonV3Voice";
		switch (idioma) {
		case "pt":
			modelo = "pt-BR_IsabelaV3Voice";
			break;
		case "en":
			modelo = "en-US_AllisonV3Voice";
			break;
		case "fr":
			modelo = "fr-FR_ReneeV3Voice";
			break;
		case "de":
			modelo = "de-DE_BirgitV3Voice";
			break;
		case "it":
			modelo = "it-IT_FrancescaV3Voice";
			break;
		case "ja":
			modelo = "ja-JP_EmiV3Voice";
			break;
		case "es":
			modelo = "ja-JP_EmiV3Voice";
			break;
		}
		System.out.println("tts - " + modelo);

		IamOptions options = new IamOptions.Builder().apiKey(iamKey).build();

		TextToSpeech service = new TextToSpeech(options);

		SynthesizeOptions sOptions = new SynthesizeOptions.Builder().text(msg).accept("audio/wav").voice(modelo)
				.build();

		InputStream is = service.synthesize(sOptions).execute().getResult();
		InputStream in = WaveUtils.reWriteWaveHeader(is);

		byte[] buffer = new byte[1024 * 1024];
		try (OutputStream os = resp.getOutputStream()) {
			int length;
			while ((length = in.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
		}

	}
}
