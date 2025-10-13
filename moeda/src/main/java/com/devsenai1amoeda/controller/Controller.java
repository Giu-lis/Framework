package com.devsenai1amoeda.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@PostMapping ("/traduzir")
	@ResponseBody 
		public Map< String, Object> traduzirJson(
				@RequestParam double valor1,
				@RequestParam String tenho,
				@RequestParam String quero ){
		
		double resultado = 0;
		String erro = null;
		
		switch (tenho) {
		case "real" :
			if (quero.equals("dolar"))
				resultado = valor1 / 5.36;
			else if (quero.equals("euro"))
				resultado = valor1 / 6.23;
			else 
				resultado = valor1;
			break;
		case "dolar" :
			if (quero.equals("real"))
				resultado = valor1 * 5.36;
			else if (quero.equals("euro"))
				resultado = valor1 * 0.86;
			else 
				resultado =  valor1;
			break;
		case "euro" :
			if (quero.equals("real"))
				resultado = valor1 * 6.23;
			else if (quero.equals("dolar"))
				resultado = valor1 * 1.16;
			else 
				resultado = valor1;
			break;
		default: erro = "Conversão inválida!";	
		}
		
		Map<String, Object> resp = new HashMap<>();
		resp.put("resultado", resultado);
		resp.put("erro", erro);
		return resp;
	}
}