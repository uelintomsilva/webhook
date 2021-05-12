package com.example.demo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.WebHookDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WebHookServiceImpl implements WebHookService{

	private static final String HookUrl = "https://webhook.site/f74c3a57-a016-43f8-ace8-3c91fa26b4b4";
	
	@Override
	public String[] createWebHook(WebHookDTO webHookDTO) throws Exception{
		
        String userWebhookUrl = String.format(HookUrl);
        StringBuilder stringBuilder = new StringBuilder();
        
        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        
        String messageJson = objectMapper.writeValueAsString(webHookDTO);
        HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);
        
        try{
        	restTemplate.exchange(userWebhookUrl, HttpMethod.POST, entity, String.class);
        	
        	stringBuilder.append("[ReportGenerated - ");
        	stringBuilder.append(webHookDTO.getBot());
        	stringBuilder.append("] \na execução ");
        	stringBuilder.append(webHookDTO.getExecution());
        	stringBuilder.append(" terminou com sucesso.");
        	return new String[] {stringBuilder.toString(),"true"};
        }catch(Exception e){
        	stringBuilder.append("[ExecutionFinishedWithError - ");
        	stringBuilder.append(webHookDTO.getBot());
        	stringBuilder.append("] \na execução ");
        	stringBuilder.append(webHookDTO.getExecution());
        	stringBuilder.append(" terminou com erros.");
        	return new String[] {stringBuilder.toString(),"false"};
        }
		
	}

}
