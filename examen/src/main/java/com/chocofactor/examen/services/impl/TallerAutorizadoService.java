package com.chocofactor.examen.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chocofactor.examen.model.VehiculoTallerAutorizado;
import com.chocofactor.examen.services.ITallerAutorizadoService;

@Service
public class TallerAutorizadoService implements ITallerAutorizadoService{
	
	public List<VehiculoTallerAutorizado> serviceVehiculoInspec() {
		ArrayList<VehiculoTallerAutorizado> listaVehiculos = new ArrayList<>();
		
		VehiculoTallerAutorizado infoVehiculo = new VehiculoTallerAutorizado();
		infoVehiculo.setPlaca("ABC123");
		infoVehiculo.setInspeccionado(false);
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new VehiculoTallerAutorizado();
		infoVehiculo.setPlaca("RTY567");
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new VehiculoTallerAutorizado();
		infoVehiculo.setPlaca("GHJ987");
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new VehiculoTallerAutorizado();
		infoVehiculo.setPlaca("XCV234");
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new VehiculoTallerAutorizado();
		infoVehiculo.setPlaca("GHJ345");
		listaVehiculos.add(infoVehiculo);
		
		return listaVehiculos;
	}

}
