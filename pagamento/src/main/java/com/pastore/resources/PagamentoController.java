package com.pastore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pastore.entities.Pagamento;
import com.pastore.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService service;
	
	@HystrixCommand(fallbackMethod = "getPagamentoAlternativo")
	@GetMapping(value = "/{funcionarioId}/{dias}")
	public ResponseEntity<Pagamento> getPagamento(@PathVariable Long funcionarioId, @PathVariable Integer dias){
		Pagamento pag = service.getPagamento(funcionarioId, dias);
		return ResponseEntity.ok(pag);
	}
	
	public ResponseEntity<Pagamento> getPagamentoAlternativo(Long funcionarioId, Integer dias){
		return ResponseEntity.ok(Pagamento.builder().nome("Não localizado").diasTrabalhados(0).rendaDiaria(0.0).build());
	}
		
}
