package com.chocofactor.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TASE_AFILIACIONES")
public class Afiliacion {
	
	public Afiliacion() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NM_ID", nullable = true)
	private Integer codigoAfiliacion;
	
	@ManyToOne
	@JoinColumn(name = "NM_ID_VEHICULO")
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "NM_ID_POLIZA")
	private Poliza poliza;
	
	@ManyToOne
	@JoinColumn(name = "NM_ID_ASEGURADO")
	private Asegurado asegurado;
	
	public Integer getCodigoAfiliacion() {
		return codigoAfiliacion;
	}
	public void setCodigoAfiliacion(Integer codigoAfiliacion) {
		this.codigoAfiliacion = codigoAfiliacion;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Poliza getPoliza() {
		return poliza;
	}
	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}
	public Asegurado getAsegurado() {
		return asegurado;
	}
	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}
	
	
}
