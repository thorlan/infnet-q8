package infnetjavaq8.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class WSConsumer {
	
	private static String url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=TLS.AX,MUS.AX";
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public void consume() {
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> forEntity = template.getForEntity(url, String.class);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(forEntity.getBody());
		String prettyJsonString = gson.toJson(je);
		
		log.info("Dados recebidos");
		log.info(prettyJsonString);
	}
	
	
	
}


/*
 * Implemente um microserviço que consuma a API do Yahoo Finanças (RestTemplate) mostrando as informações na console. A URL aberta é a seguinte:
 */
