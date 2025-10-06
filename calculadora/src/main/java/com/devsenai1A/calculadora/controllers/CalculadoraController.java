package com.devsenai1A.calculadora.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {
	
	@PostMapping("/calcular")
	@ResponseBody
    public Map<String, Object> calcularJson(
    		@RequestParam double num1,
    		@RequestParam double num2,
    		@RequestParam String operacao){
		
		double resultado =0;
		String erro = null;
		
		switch(operacao) {
		case "somar": resultado = num1 + num2; break;
		case "subtrair": resultado = num1 - num2; break;
		case "multiplicar": resultado = num1 * num2; break;
		case "dividir": 
			if(num2 ==0) erro = "Divisão por zero não é permitido.";
			else resultado = num1 / num2; break;
		default: erro = "Operação inválida";
		}
		
		Map<String, Object> resp = new HashMap<>();
		resp.put("resultado", resultado);
		resp.put("erro", erro);
		return resp;
		
		
		
	}		
    		
    		
}
