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


@CrossOrigin(origins = "*")
@RestController
public class CuentaControler {


	@Autowired
	private ServicioCuenta servicioCuenta;

	@PostMapping(value = "/cuentas")
	public ResponseEntity<CuentaDto> createCliente(@RequestBody CuentaDto cuentaDto) {
		CuentaDto createdCliente = servicioCuenta.createCuenta(cuentaDto);
		return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/cuentas/{cuentaId}")
	public ResponseEntity<CuentaDto> getCuenta(@PathVariable("cuentaId") Integer cuentaId) {
		CuentaDto cliente = servicioCuenta.getClienteById(cuentaId);
	    return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/cuentas")
	public ResponseEntity<List<CuentaDto>> getCuentas() {
		List<CuentaDto> clientes = servicioCuenta.listaCuenta();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/cuentas")
	public ResponseEntity<CuentaDto> updateCuenta(@RequestBody CuentaDto cuentaDto) {
		CuentaDto createdCliente = servicioCuenta.updateCuenta(cuentaDto);
		return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/cuentas/{cuentaId}")
	public ResponseEntity<CuentaDto> deleteCuenta(@PathVariable("cuentaId") Integer cuentaId) {
	    servicioCuenta.deleteCuenta(cuentaId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
