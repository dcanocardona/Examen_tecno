package com.chocofactor.examen.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chocofactor.examen.model.PersonaCentralRiesgo;
import com.chocofactor.examen.services.ICentralesRiesgoService;

@Service
public class CentralesRiesgoService implements ICentralesRiesgoService{
	
	public List<PersonaCentralRiesgo> serviceCentralRiesgo(){
		ArrayList<PersonaCentralRiesgo> listaPersonas = new ArrayList<>();
		
		PersonaCentralRiesgo persona = new PersonaCentralRiesgo();
		persona.setDocumento("45643");
		persona.setReportado(true);
		listaPersonas.add(persona);
		
		persona = new PersonaCentralRiesgo();
		persona.setDocumento("56435");
		persona.setReportado(false);
		listaPersonas.add(persona);
		
		persona = new PersonaCentralRiesgo();
		persona.setDocumento("2456567");
		persona.setReportado(true);
		listaPersonas.add(persona);
		
		persona = new PersonaCentralRiesgo();
		persona.setDocumento("2345243");
		persona.setReportado(false);
		listaPersonas.add(persona);
		
		persona = new PersonaCentralRiesgo();
		persona.setDocumento("6745345");
		persona.setReportado(true);
		listaPersonas.add(persona);

		return listaPersonas;
	}

}
