package com.example.demo.service;

import com.example.demo.dto.WebHookDTO;

public interface WebHookService {

	String[] createWebHook(WebHookDTO webHookDTO) throws Exception;
}
