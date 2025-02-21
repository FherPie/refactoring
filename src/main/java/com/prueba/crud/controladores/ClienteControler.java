package com.prueba.crud.controladores;


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
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;


@CrossOrigin(origins = "*")
@RestController
public class ClienteControler {


	@Autowired
	private ServicioCliente servicioCliente;

	@PostMapping(value = "/clientes")
	public Mono<ResponseEntity<ClienteDto>> createCliente(@RequestBody ClienteDto clienteDto) {
		return servicioCliente.createCliente(clienteDto)
				.map(createdCliente -> new ResponseEntity<>(createdCliente, HttpStatus.CREATED));
	}


	@GetMapping(value = "/clientes/{clienteId}")
	public Mono<ResponseEntity<ClienteDto>> getCliente(@PathVariable("clienteId") Integer clienteId) {
		return servicioCliente.getClienteById(clienteId)
				.map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping(value = "/clientes")
	public Flux<ClienteDto> getClientes() {
		return servicioCliente.listaCliente();
	}


	@PutMapping(value = "/clientes")
	public Mono<ResponseEntity<ClienteDto>> updateCliente(@RequestBody ClienteDto clienteDto) {
		return servicioCliente.updateCliente(clienteDto)
				.map(updatedCliente -> new ResponseEntity<>(updatedCliente, HttpStatus.OK));
	}

	@DeleteMapping(value = "/clientes/{clienteId}")
	public Mono<ResponseEntity<Void>> deleteCliente(@PathVariable("clienteId") Integer clienteId) {
		return servicioCliente.deleteCliente(clienteId)
				.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
	}
}
