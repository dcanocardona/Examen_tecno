package com.chocofactor.examen.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASE_POLIZAS")
public class Poliza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NM_ID", nullable = false)
	private Integer numero;
	
	@Column(name = "VM_VALOR", nullable = false)
	private BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
