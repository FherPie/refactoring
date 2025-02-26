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

import com.prueba.crud.dto.CuentaDto;
import com.prueba.crud.interfaces.ServicioCuenta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin(origins = "*")
@RestController
public class CuentaControler {


	@Autowired
	private ServicioCuenta servicioCuenta;


	@PostMapping(value = "/cuentas")
	public Mono<ResponseEntity<CuentaDto>> createCliente(@RequestBody CuentaDto cuentaDto) {
		return servicioCuenta.createCuenta(cuentaDto)
				.map(createdCliente -> new ResponseEntity<>(createdCliente, HttpStatus.CREATED));
	}



	@GetMapping(value = "/cuentas/{cuentaId}")
	public Mono<ResponseEntity<CuentaDto>> getCuenta(@PathVariable("cuentaId") Integer cuentaId) {
		return servicioCuenta.getClienteById(cuentaId)
				.map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}



	@GetMapping(value = "/cuentas")
	public Flux<CuentaDto> getCuentas() {
		return servicioCuenta.listaCuenta();
	}


	@PutMapping(value = "/cuentas")
	public Mono<ResponseEntity<CuentaDto>> updateCuenta(@RequestBody CuentaDto cuentaDto) {
		return servicioCuenta.updateCuenta(cuentaDto)
				.map(updatedCliente -> new ResponseEntity<>(updatedCliente, HttpStatus.OK));
	}

	@DeleteMapping(value = "/cuentas/{cuentaId}")
	public ResponseEntity<CuentaDto> deleteCuenta(@PathVariable("cuentaId") Integer cuentaId) {
	    servicioCuenta.deleteCuenta(cuentaId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
