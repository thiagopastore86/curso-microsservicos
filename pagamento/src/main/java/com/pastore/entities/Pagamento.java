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
//@Entity
//@Table(name = "pagamento")
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 3107490183416201856L;
	
	private String nome;
	private Double rendaDiaria;
	private Integer diasTrabalhados;

	public Double getTotal() {
		return this.diasTrabalhados * this.rendaDiaria;
	}
}
