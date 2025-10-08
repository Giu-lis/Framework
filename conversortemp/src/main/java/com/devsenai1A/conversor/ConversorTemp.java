package com.devsenai1A.conversor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorTemp {
	
	@PostMapping("/converter")
	@ResponseBody
	public Map<String, Object> converterJson(
			@RequestParam double temp,
			@RequestParam String unidade,
			@RequestParam String unidade2){
		
				double resultado=0;
				String erro = null;
				
				switch(unidade) {
				case "farenheit":
					if(unidade2.equals("celsius"))
						resultado = (temp - 32) * 5/9;
					else if (unidade2.equals("kelvin"))
						resultado = (temp - 32) * 5/9 + 273.15;
					else
						resultado = temp;
					break;
				case "celsius":
					if(unidade2.equals("farenheit"))
						resultado = (temp * 1.8) + 32;
					else if (unidade2.equals("kelvin"))
						resultado = temp + 273.15;
					else
						resultado = temp;
					break;
					
				case "kelvin":
					if(unidade2.equals("farenheit"))
						resultado = (temp - 273.15) * 1.8 + 32;
					else if (unidade2.equals("celsius"))
						resultado = temp - 273.15;
					else 
						resultado = temp;
					break;
				default: erro = "Conversão inválida";
				}
				
				Map<String, Object> resp = new HashMap<>();
				resp.put("resultado", resultado);
				resp.put("erro", erro);
				return resp;
	}

}
