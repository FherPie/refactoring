package com.prueba.crud.interfaces;

import java.util.List;

import com.prueba.crud.dto.ClienteDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicioCliente {
	
	Mono<ClienteDto> createCliente(ClienteDto clienteDto);
	Mono<ClienteDto> updateCliente(ClienteDto clienteDto);
	Mono<ClienteDto> getClienteById(Integer employeeId);
    Flux<ClienteDto> listaCliente();
	Mono<Void> deleteCliente(Integer clienteId);
}
