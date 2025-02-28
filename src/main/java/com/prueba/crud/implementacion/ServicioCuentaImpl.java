package com.prueba.crud.implementacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.crud.dto.CuentaDto;
import com.prueba.crud.entidades.Cuenta;
import com.prueba.crud.interfaces.ServicioCuenta;
import com.prueba.crud.mapper.CuentaMapper;
import com.prueba.crud.repositorios.ClienteRepository;
import com.prueba.crud.repositorios.CuentaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicioCuentaImpl implements ServicioCuenta {

	@Autowired
	CuentaRepository cuentaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Mono<CuentaDto> createCuenta(CuentaDto cuentaDto) {
		return clienteRepository.findById(cuentaDto.getClienteId()) // Busca el cliente de manera reactiva
				.flatMap(cliente -> { // Si el cliente existe, continúa con el flujo
					Cuenta cuenta = CuentaMapper.toEntity(cuentaDto); // Mapea el DTO a la entidad
					//cuenta.setCliente(cliente); // Asocia el cliente a la cuenta
					return cuentaRepository.save(cuenta) // Guarda la cuenta de manera reactiva
							.map(CuentaMapper::toDto); // Mapea la entidad guardada de vuelta al DTO
				})
				.switchIfEmpty(Mono.error(new RuntimeException("Cliente no encontrado"))); // Maneja el caso donde el cliente no existe
	}


	@Override
	public Mono<CuentaDto> updateCuenta(CuentaDto cuentaDto) {
		// Primero, buscamos la cuenta existente para asegurarnos de que existe antes de actualizarla
		return cuentaRepository.findById(cuentaDto.getCuentaId())
				.flatMap(existingCuenta -> {
					// Mapea el DTO a la entidad
					Cuenta cuenta = CuentaMapper.toEntity(cuentaDto);
					// Actualiza los detalles de la cuenta existente con los nuevos valores
					//cuenta.setCliente(existingCuenta.getCliente()); // Mantiene el cliente asociado
					// Guarda la cuenta actualizada de manera reactiva
					return cuentaRepository.save(cuenta)
							.map(CuentaMapper::toDto); // Mapea la entidad guardada de vuelta al DTO
				})
				.switchIfEmpty(Mono.error(new RuntimeException("Cuenta no encontrada"))); // Maneja el caso donde la cuenta no existe
	}

	@Override
	public Mono<CuentaDto> getClienteById(Integer cuentaId) {
		return cuentaRepository.findById(cuentaId).map(CuentaMapper::toDto);
	}

	@Override
	public Flux<CuentaDto> listaCuenta() {
		return cuentaRepository.findAll().map(CuentaMapper::toDto);
	}

	@Override
	public void deleteCuenta(Integer cuentaId) {
		cuentaRepository.deleteById(cuentaId);
	}



}
