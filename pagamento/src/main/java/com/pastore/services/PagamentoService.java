package com.pastore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pastore.entities.Funcionario;
import com.pastore.entities.Pagamento;
import com.pastore.feignclients.FuncionarioFeignClient;

@Service
public class PagamentoService {
	
	@Autowired
	private FuncionarioFeignClient funcFC;
	
	public Pagamento getPagamento(long funcionarioId, int dias) {
		
		Funcionario func = funcFC.findById(funcionarioId).getBody();
		
		return Pagamento.builder().nome(func.getNome()).diasTrabalhados(dias).rendaDiaria(func.getValorDia()).build();
	}

}
