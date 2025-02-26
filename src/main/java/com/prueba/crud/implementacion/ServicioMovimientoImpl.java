package com.prueba.crud.implementacion;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.crud.dto.MovimientoDto;
import com.prueba.crud.entidades.Cuenta;
import com.prueba.crud.entidades.Movimiento;
import com.prueba.crud.interfaces.ServicioMovimiento;
import com.prueba.crud.mapper.MovimientoMapper;
import com.prueba.crud.repositorios.CuentaRepository;
import com.prueba.crud.repositorios.MovimientoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ServicioMovimientoImpl implements ServicioMovimiento {

	@Autowired
	MovimientoRepository movimientoRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;


	@Override
	public Mono<MovimientoDto> createMovimiento(MovimientoDto movimientoDto) {
		return cuentaRepository.findById(movimientoDto.getCuentaId())
				.flatMap(cuenta -> crearMovimiento(cuenta, movimientoDto))
				.switchIfEmpty(Mono.error(new RuntimeException("Cuenta no encontrada")));
	}


	private Mono<MovimientoDto> crearMovimiento(Cuenta cuenta, MovimientoDto requestMovimiento) {
		Movimiento movimiento = MovimientoMapper.toEntity(requestMovimiento);
		movimiento.setCuenta(cuenta);

		if (requestMovimiento.getValor() < 0.0) {
			Double valorAbsoluto = Math.abs(requestMovimiento.getValor());
			if (valorAbsoluto > cuenta.getSaldo()) {
				return Mono.just(MovimientoDto.builder().mensaje("SALDO_NO_DISPONIBLE").build());
			}
		}

		cuenta.setSaldo(cuenta.getSaldo() + requestMovimiento.getValor());
		return cuentaRepository.save(cuenta)
				.then(movimientoRepository.save(movimiento))
				.map(savedMovimiento -> {
					MovimientoDto dto = MovimientoMapper.toDto(savedMovimiento);
					dto.setMensaje("EXITO");
					return dto;
				});
	}


	@Override
	public Mono<MovimientoDto> updateMovimiento(MovimientoDto movimientoDto) {
		return movimientoRepository.findById(movimientoDto.getMovimientoId())
				.flatMap(existingMovimiento -> {
					Movimiento movimiento = MovimientoMapper.toEntity(movimientoDto);
					movimiento.setCuenta(existingMovimiento.getCuenta());
					return movimientoRepository.save(movimiento)
							.map(MovimientoMapper::toDto);
				})
				.switchIfEmpty(Mono.error(new RuntimeException("Movimiento no encontrado")));
	}

	@Override
	public Mono<MovimientoDto> getMovimientoById(Integer movimientoId) {
		return movimientoRepository.findById(movimientoId)
				.map(MovimientoMapper::toDto);
	}

	@Override
	public Flux<MovimientoDto> listaMovimiento() {
		return movimientoRepository.findAll()
				.map(MovimientoMapper::toDto);
	}

	@Override
	public Mono<Void> deleteMovimiento(Integer movimientoId) {
		return movimientoRepository.deleteById(movimientoId);
	}


}
