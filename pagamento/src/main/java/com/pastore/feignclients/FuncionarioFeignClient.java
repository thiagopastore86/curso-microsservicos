package com.pastore.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pastore.entities.Funcionario;

@Component
@FeignClient(name = "ms-funcionario", url = "http://localhost:8001", path = "/funcionarios")
public interface FuncionarioFeignClient {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id);


}
