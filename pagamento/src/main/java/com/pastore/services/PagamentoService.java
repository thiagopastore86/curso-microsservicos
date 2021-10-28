package com.pastore.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pastore.entities.Funcionario;
import com.pastore.entities.Pagamento;

@Service
public class PagamentoService {
	
	@Value("${funcionario.host}")
	private String funcionarioHost;
	
	@Autowired
	private RestTemplate padraoRest;
	
	public Pagamento getPagamento(long funcionarioId, int dias) {
		
		Map<String, String> uriVar = new HashMap<>();
		uriVar.put("Id", ""+funcionarioId);
		
		Funcionario func = padraoRest.getForObject(funcionarioHost+"/funcionarios/{Id}", Funcionario.class, uriVar);
		
		return Pagamento.builder().nome(func.getNome()).diasTrabalhados(dias).rendaDiaria(func.getValorDia()).build();
	}

}
