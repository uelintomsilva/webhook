package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;


public class WebHookDTO {

	@NotBlank(message="evt não pode ser vazio.")
	private String evt;
	
	@NotBlank(message="execution não pode ser vazio.")
	private String execution;
	
	
	@Positive(message="owner não pode ser negativo.")
	private int owner;
	
	@NotBlank(message="bot não pode ser vazio.")
	private String bot;
	
	public WebHookDTO(String _evt, String _execution, int _owner, String _bot) {
		this.evt = _evt;
		this.execution = _execution;
		this.owner = _owner;
		this.bot = _bot;
	}
	
	public WebHookDTO toWebHook(WebHookDTO webHookDTO) {
		
		return new WebHookDTO(webHookDTO.evt,webHookDTO.execution,webHookDTO.owner,webHookDTO.bot);
	}
	
}
