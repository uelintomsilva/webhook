package com.example.demo.service;

import java.net.HttpURLConnection;
import java.net.URL;

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
	public WebHookDTO createWebHook(WebHookDTO webHookDTO) throws Exception{
		
		
		
        String userWebhookUrl = String.format(HookUrl);

        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

      

        ObjectMapper objectMapper = new ObjectMapper();
        String message = "oi";
        String messageJson = objectMapper.writeValueAsString(message);

      

        HttpEntity<String> entity = new HttpEntity<>(messageJson, headers);
        restTemplate.exchange(userWebhookUrl, HttpMethod.POST, entity, String.class);
		
		
		
		return null;
	}

}
