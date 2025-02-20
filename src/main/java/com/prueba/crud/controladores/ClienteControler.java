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

import com.prueba.crud.dto.ClienteDto;
import com.prueba.crud.interfaces.ServicioCliente;

@CrossOrigin(origins = "*")
@RestController
public class ClienteControler {


	@Autowired
	private ServicioCliente servicioCliente;

	@PostMapping(value = "/clientes")
	public ResponseEntity<ClienteDto> createCliente(@RequestBody ClienteDto clienteDto) {
		ClienteDto createdCliente = servicioCliente.createCliente(clienteDto);
		return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/clientes/{clienteId}")
	public ResponseEntity<ClienteDto> getEmployee(@PathVariable("clienteId") Integer clienteId) {
		ClienteDto cliente = servicioCliente.getClienteById(clienteId);
	    return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/clientes")
	public ResponseEntity<List<ClienteDto>> getClientes() {
		List<ClienteDto> clientes = servicioCliente.listaCliente();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/clientes")
	public ResponseEntity<ClienteDto> updateCliente(@RequestBody ClienteDto clienteDto) {
		ClienteDto createdCliente = servicioCliente.createCliente(clienteDto);
		return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/clientes/{clienteId}")
	public ResponseEntity<ClienteDto> deleteCliente(@PathVariable("clienteId") Integer clienteId) {
	    servicioCliente.deleteCliente(clienteId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
