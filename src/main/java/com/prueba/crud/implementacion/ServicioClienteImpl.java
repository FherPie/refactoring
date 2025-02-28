package com.prueba.crud.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.crud.dto.ClienteDto;
import com.prueba.crud.entidades.Cliente;
import com.prueba.crud.interfaces.ServicioCliente;
import com.prueba.crud.mapper.ClienteMapper;
import com.prueba.crud.repositorios.ClienteRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicioClienteImpl implements ServicioCliente {

	@Autowired
	ClienteRepository clienteRepository;
	

	@Override
	public Mono<ClienteDto> createCliente(ClienteDto clienteDto) {
		Cliente cliente = ClienteMapper.toEntity(clienteDto);
		cliente.setCuentas(new ArrayList<>());
		return clienteRepository.save(cliente)
				.map(ClienteMapper::toDto);
	}

	@Override
	public Mono<ClienteDto> updateCliente(ClienteDto clienteDto) {
		Cliente cliente = ClienteMapper.toEntity(clienteDto);
		return clienteRepository.save(cliente)
				.map(ClienteMapper::toDto);
	}

	@Override
	public Mono<ClienteDto> getClienteById(Integer clienteId) {
		return clienteRepository.findById(clienteId)
				.map(ClienteMapper::toDto);
	}


	@Override
	public Flux<ClienteDto> listaCliente() {
		return clienteRepository.findAll()
				.map(ClienteMapper::toDto);
	}

	@Override
	public Mono<Void> deleteCliente(Integer clienteId) {
		return clienteRepository.deleteById(clienteId);
	}
}
