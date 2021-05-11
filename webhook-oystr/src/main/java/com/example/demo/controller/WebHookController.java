package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping(value="/webhook", consumes={"application/json"})
	public ResponseEntity<Boolean> postPayLoad(@RequestBody WebHookDTO webHookDTO) throws Exception{
		
		webHookService.createWebHook(webHookDTO.toWebHook(webHookDTO));
		
		return null;
		
	}
}
