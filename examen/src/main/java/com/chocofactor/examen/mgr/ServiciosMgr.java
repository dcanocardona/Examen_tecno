package com.chocofactor.examen.mgr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chocofactor.examen.model.Afiliacion;
import com.chocofactor.examen.model.Asegurado;
import com.chocofactor.examen.model.InfoVehiculo;
import com.chocofactor.examen.model.PersonaCentralRiesgo;
import com.chocofactor.examen.model.Vehiculo;
import com.chocofactor.examen.model.VehiculoTallerAutorizado;
import com.chocofactor.examen.repository.AfiliacionRepository;
import com.chocofactor.examen.repository.AseguradoRepository;
import com.chocofactor.examen.repository.PolizaRepository;
import com.chocofactor.examen.repository.VehiculoRepository;
import com.chocofactor.examen.services.ICentralesRiesgoService;
import com.chocofactor.examen.services.IPoliciaService;
import com.chocofactor.examen.services.ITallerAutorizadoService;

@Service
public class ServiciosMgr {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Autowired
	private AseguradoRepository aseguradoRepository;
	
	@Autowired
	private PolizaRepository polizaRepository;
	
	@Autowired
	private AfiliacionRepository afiliacionRepository;
	
	@Autowired
	private IPoliciaService policiaService;
	
	@Autowired
	private ITallerAutorizadoService tallerAutorizadoService;
	
	@Autowired
	private ICentralesRiesgoService centralesRiesgoService;
	
	public Afiliacion asegurarVehiculo(Afiliacion afiliacion) throws Exception {
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(afiliacion.getVehiculo().getPlaca());
		
		if(validarAfiliacion(afiliacion) && vehiculo != null) {
			afiliacion.setVehiculo(vehiculo);
			aseguradoRepository.save(afiliacion.getAsegurado());
			
			polizaRepository.save(afiliacion.getPoliza());
			
			afiliacionRepository.save(afiliacion);
				
			
		}else {
			throw new Exception("Err");
		}
		
		return afiliacion;
		
	}
	
	private boolean validarAfiliacion(Afiliacion afiliacion) {
		boolean afiliar = true;
		if(afiliacion.getVehiculo() != null) {
			
			if(validarVehiculoRobado(afiliacion.getVehiculo())) {
				afiliar = false;
			}
			if(!validarVehiculoInspeccionado(afiliacion.getVehiculo())) {
				afiliar = false;
			}
			if(!validarPolizaFinanciada(afiliacion)){
				afiliar = false;
			}
			if(validarCentralesRiesgo(afiliacion.getAsegurado())) {
				afiliar = false;
			}
			if(!validarEdadAsegurado(afiliacion.getAsegurado().getEdad())) {
				afiliar = false;
			}
		}else {
			afiliar = false;
		}
		return afiliar;
	}
	
	private boolean validarVehiculoRobado(Vehiculo vehiculo) {
		boolean vehiculoRobado = false;
		InfoVehiculo infoVehiculo = policiaService.serviceInfoVehiculo().stream().filter(t -> t.getPlaca().equals(vehiculo.getPlaca())).findFirst().orElse(null);
		if(infoVehiculo != null) {
			vehiculoRobado = true;
		}
		return vehiculoRobado;
	}
	
	private boolean validarVehiculoInspeccionado(Vehiculo vehiculo) {
		boolean vehiculoInspeccionado = false;
		VehiculoTallerAutorizado vehiculoTallerAutorizado = tallerAutorizadoService.serviceVehiculoInspec().stream().filter(t -> t.getPlaca().equals(vehiculo.getPlaca())).findFirst().orElse(null);
		if(vehiculoTallerAutorizado != null) {
			vehiculoInspeccionado = true;
		}
		return vehiculoInspeccionado;
	}
	
	private boolean validarPolizaFinanciada(Afiliacion afiliacion) {
		boolean liquidezValida = true;
		BigDecimal vlrPolizaMencual = afiliacion.getPoliza().getValor().divide(new BigDecimal(11), 2, RoundingMode.HALF_UP);
		BigDecimal excesoMensual = afiliacion.getAsegurado().getSalario().subtract(afiliacion.getAsegurado().getGastosFijos()).subtract(afiliacion.getAsegurado().getCreditos());
		if(excesoMensual.compareTo(vlrPolizaMencual) < 1) {
			liquidezValida = false;
		}
		return liquidezValida;
	}
	
	private boolean validarCentralesRiesgo(Asegurado asegurado) {
		boolean personaReportado = false;
		PersonaCentralRiesgo personasReportada = centralesRiesgoService.serviceCentralRiesgo().stream().filter(t -> t.getDocumento().equals(asegurado.getDocumento())).findFirst().orElse(null);
		if(personasReportada != null) {
			personaReportado = true;			
		}
		return personaReportado;
	}
	
	private boolean validarEdadAsegurado(Integer edadAsegurado) {
		return edadAsegurado >= 18;
	}

}
