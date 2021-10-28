package com.pastore.services;

import org.springframework.stereotype.Service;

import com.pastore.entities.Pagamento;

@Service
public class PagamentoService {
	
	public Pagamento getPagamento(long funcionarioId, int dias) {
		return Pagamento.builder().nome("Bob").diasTrabalhados(dias).rendaDiaria(200.5).build();
	}

}
