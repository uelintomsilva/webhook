package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.WebHookDTO;
import com.example.demo.service.WebHookService;

@RestController
public class WebHookController {

	@Autowired
	private WebHookService webHookService;
		
	@PostMapping("/webhook")
	public ResponseEntity<String> postPayLoad(@Valid @RequestBody WebHookDTO webHookDTO) throws Exception{
		
		String[] msg = webHookService.createWebHook(webHookDTO.toWebHook(webHookDTO));
		
		if(msg[1]=="true") return new ResponseEntity<>(msg[0],HttpStatus.OK);
		return new ResponseEntity<>(msg[0],HttpStatus.SERVICE_UNAVAILABLE);
		
	}
}
