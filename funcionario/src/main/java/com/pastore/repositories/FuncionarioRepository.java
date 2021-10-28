package com.pastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pastore.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
