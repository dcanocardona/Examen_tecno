package com.chocofactor.examen.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chocofactor.examen.model.InfoVehiculo;
import com.chocofactor.examen.services.IPoliciaService;

@Service
public class PoliciaService implements IPoliciaService{

	public List<InfoVehiculo> serviceInfoVehiculo() {
		ArrayList<InfoVehiculo> listaVehiculos = new ArrayList<>();
		
		InfoVehiculo infoVehiculo = new InfoVehiculo();
		infoVehiculo.setPlaca("ABC129");
		infoVehiculo.setRobado(false);
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new InfoVehiculo();
		infoVehiculo.setPlaca("RTY567");
		infoVehiculo.setRobado(true);
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new InfoVehiculo();
		infoVehiculo.setPlaca("GHJ987");
		infoVehiculo.setRobado(false);
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new InfoVehiculo();
		infoVehiculo.setPlaca("XCV234");
		infoVehiculo.setRobado(true);
		listaVehiculos.add(infoVehiculo);
		
		infoVehiculo = new InfoVehiculo();
		infoVehiculo.setPlaca("GHJ345");
		infoVehiculo.setRobado(false);
		listaVehiculos.add(infoVehiculo);
		
		return listaVehiculos;
	}
}
