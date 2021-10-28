package com.pastore.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Funcionario implements Serializable{
	private static final long serialVersionUID = -1687160884948275431L;
	
	private Long id;
	private String nome;
	private Double valorDia;
	
}
