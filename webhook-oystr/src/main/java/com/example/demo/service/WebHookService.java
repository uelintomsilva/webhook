package com.example.demo.service;

import com.example.demo.dto.WebHookDTO;
import com.example.demo.model.WebHook;

public interface WebHookService {

	WebHookDTO createWebHook(WebHookDTO webHookDTO) throws Exception;
}
