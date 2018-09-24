package com.chocofactor.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chocofactor.examen.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer>{

	
    Vehiculo findByPlaca(String placa);
}
