package com.chocofactor.examen.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASE_ASEGURADOS")
public class Asegurado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NM_ID", nullable = false)
	private Integer idAsegurado;

	@Column(name = "DS_DOCUMENTO", nullable = false)
	private String documento;
	
	@Column(name = "VM_SALARIO", nullable = false)
	private BigDecimal salario;
	
	@Column(name = "VM_CREDITOS", nullable = false)
	private BigDecimal creditos;
	
	@Column(name = "VM_GASTOS_FIJOS", nullable = false)
	private BigDecimal gastosFijos;
	
	@Column(name = "NM_EDAD", nullable = false)
	private Integer edad;

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public Integer getIdAsegurado() {
		return idAsegurado;
	}

	public void setIdAsegurado(Integer idAsegurado) {
		this.idAsegurado = idAsegurado;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getCreditos() {
		return creditos;
	}

	public void setCreditos(BigDecimal creditos) {
		this.creditos = creditos;
	}

	public BigDecimal getGastosFijos() {
		return gastosFijos;
	}

	public void setGastosFijos(BigDecimal gastosFijos) {
		this.gastosFijos = gastosFijos;
	}

	
}
