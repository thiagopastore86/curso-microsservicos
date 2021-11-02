package com.pastore.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pastore.entities.Funcionario;
import com.pastore.repositories.FuncionarioRepository;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	private static Logger log = org.slf4j.LoggerFactory.getLogger(Funcionario.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> list = funcionarioRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
		
		/*try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Porta: "+env.getProperty("local.server.port"));*/
		
		Funcionario func = funcionarioRepository.findById(id).get();
		return ResponseEntity.ok(func);
	}

}
