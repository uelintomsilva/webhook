package com.example.demo.model;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.example.demo.dto.WebHookDTO;

import javax.persistence.Entity;


@Table(name="webhook")
public class WebHook {

	@NotBlank(message="evt não pode ser vazio.")
	private String evt;
	
	@NotBlank(message="execution não pode ser vazio.")
	private String execution;
	
	@NotEmpty(message="owner não pode ser vazio.")
	@Positive(message="owner não pode ser negativo.")
	private int owner;
	
	@NotBlank(message="bot não pode ser vazio.")
	private String bot;
	
	/*public WebHook(String _evt, String _execution, int _owner, String _bot) {
		this.evt = _evt;
		this.execution = _execution;
		this.owner = _owner;
		this.bot = _bot;
	}*/
	
	public WebHook(WebHookDTO webHookDTO) {
		
	} 
}
