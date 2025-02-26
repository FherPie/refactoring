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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class MovimientoControler {

	@Autowired
	private ServicioMovimiento servicioMovimiento;



	@PostMapping(value = "/movimientos")
	public Mono<ResponseEntity<MovimientoDto>> createMovimiento(@RequestBody MovimientoDto movimientoDto) {
		return servicioMovimiento.createMovimiento(movimientoDto)
				.map(createdMovimiento -> new ResponseEntity<>(createdMovimiento, HttpStatus.CREATED));
	}




	@GetMapping(value = "/movimientos/{movimientoId}")
	public Mono<ResponseEntity<MovimientoDto>> getMovimiento(@PathVariable("movimientoId") Integer movimientoId) {
		return servicioMovimiento.getMovimientoById(movimientoId)
				.map(movimiento -> new ResponseEntity<>(movimiento, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}




	@GetMapping(value = "/movimientos")
	public Flux<MovimientoDto> getMovimientos() {
		return servicioMovimiento.listaMovimiento();
	}


	@PutMapping(value = "/movimientos")
	public Mono<ResponseEntity<MovimientoDto>> updateMovimiento(@RequestBody MovimientoDto movimientoDto) {
		return servicioMovimiento.updateMovimiento(movimientoDto)
				.map(updatedMovimiento -> new ResponseEntity<>(updatedMovimiento, HttpStatus.OK));
	}

	@DeleteMapping(value = "/movimientos/{movimientoId}")
	public Mono<ResponseEntity<Void>> deleteMovimiento(@PathVariable("movimientoId") Integer movimientoId) {
		return servicioMovimiento.deleteMovimiento(movimientoId)
				.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
	}
	
}
