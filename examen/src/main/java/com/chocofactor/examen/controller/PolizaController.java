package com.chocofactor.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chocofactor.examen.mgr.ServiciosMgr;
import com.chocofactor.examen.model.Afiliacion;

@RestController
public class PolizaController {
	
	@Autowired
	ServiciosMgr serviciosMgr;

	@PostMapping("/asegurarVehiculo")
	public ResponseEntity<Afiliacion> asegurarVehiculo(@RequestBody Afiliacion afiliacion) throws Exception{
		
		try {
			serviciosMgr.asegurarVehiculo(afiliacion);			
			return new ResponseEntity<>(afiliacion, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(new Afiliacion(), HttpStatus.NOT_IMPLEMENTED);
		}
		
		
	}
}
