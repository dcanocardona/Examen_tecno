package com.chocofactor.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TASE_VEHICULOS")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NM_ID", nullable = false)
	private Integer idVehiculo;
	
	@Column(name = "DS_PLACA", nullable = false)
	private String placa;
	
	@Column(name = "NM_MODELO", nullable = false)
	private Integer modelo;
	
	@Column(name = "CD_MARCA", nullable = false)
	private String marca;
	
	@Column(name = "NM_CANTIDAD_PASAJEROS", nullable = false)
	private Integer nroPasajeros;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getNroPasajeros() {
		return nroPasajeros;
	}
	public void setNroPasajeros(Integer nroPasajeros) {
		this.nroPasajeros = nroPasajeros;
	}
	
	public Integer getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}	

}
