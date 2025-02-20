package com.prueba.crud.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.crud.dto.MovimientoDto;
import com.prueba.crud.interfaces.ServicioMovimiento;

@CrossOrigin(origins = "*")
@RestController
public class MovimientoControler {

	@Autowired
	private ServicioMovimiento servicioMovimiento;

	@PostMapping(value = "/movimientos")
	public ResponseEntity<MovimientoDto> createMovimiento(@RequestBody MovimientoDto movimientoDto) {
		MovimientoDto createdMovimiento = servicioMovimiento.createMovimiento(movimientoDto);
		return new ResponseEntity<>(createdMovimiento, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/movimientos/{movimientoId}")
	public ResponseEntity<MovimientoDto> getMovimiento(@PathVariable("movimientoId") Integer movimientoId) {
		MovimientoDto movimiento = servicioMovimiento.getMovimientoById(movimientoId);
	    return new ResponseEntity<>(movimiento, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/movimientos")
	public ResponseEntity<List<MovimientoDto>> getMovimientos() {
		List<MovimientoDto> movimientos = servicioMovimiento.listaMovimiento();
		return new ResponseEntity<>(movimientos, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/movimientos")
	public ResponseEntity<MovimientoDto> updateMovimiento(@RequestBody MovimientoDto movimientoDto) {
		MovimientoDto createdMovimiento = servicioMovimiento.updateMovimiento(movimientoDto);
		return new ResponseEntity<>(createdMovimiento, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/movimientos/{movimientoId}")
	public ResponseEntity<MovimientoDto> deleteMovimiento(@PathVariable("movimientoId") Integer movimientoId) {
	    servicioMovimiento.deleteMovimiento(movimientoId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
