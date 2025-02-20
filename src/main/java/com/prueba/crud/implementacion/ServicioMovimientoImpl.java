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

@Service
@Transactional
public class ServicioMovimientoImpl implements ServicioMovimiento {

	@Autowired
	MovimientoRepository movimientoRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;


	@Override
	public MovimientoDto createMovimiento(MovimientoDto movimientoDto) {
		Optional<Cuenta> cuenta = cuentaRepository.findById(movimientoDto.getCuentaId());
		return crearMovimiento(cuenta.get(), movimientoDto);
	}
	
	
	
	private MovimientoDto crearMovimiento(Cuenta cuenta, MovimientoDto requestMovimiento) {
		try {
			Movimiento movimiento = null;		
				if (requestMovimiento.getValor() < 0.0) {
					Double valorAbsotulo= Math.abs(requestMovimiento.getValor());
					
					if (valorAbsotulo > cuenta.getSaldo() ) { // Mayor retiro que saldo inicial																						// saldo incial
						return MovimientoDto.builder().mensaje("SALDO_NO_DISPONIBLE").build();
					} else {			
						movimiento = Movimiento.builder().cuenta(cuenta).fecha(requestMovimiento.getFecha())
								.tipo("RETIRO").valor(requestMovimiento.getValor()).build();
						movimiento=movimientoRepository.save(movimiento);
					}
				} else {
					movimiento = Movimiento.builder().cuenta(cuenta).fecha(requestMovimiento.getFecha())
							.tipo("DEPOSITO").valor(requestMovimiento.getValor()).build();
					movimiento=movimientoRepository.save(movimiento);
				}
				cuenta.setSaldo(cuenta.getSaldo()+requestMovimiento.getValor());
				cuentaRepository.save(cuenta);
				MovimientoDto dto=MovimientoMapper.toDto(movimiento);
				dto.setMensaje("EXITO");
				return dto;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	
	

	@Override
	public MovimientoDto updateMovimiento(MovimientoDto movimientoDto) {
		Movimiento movimiento=MovimientoMapper.toEntity(movimientoDto);
		movimiento=movimientoRepository.save(movimiento);
		return MovimientoMapper.toDto(movimiento);
	}

	@Override
	public MovimientoDto getMovimientoById(Integer movimientoId) {
		  return MovimientoMapper.toDto(movimientoRepository.getReferenceById(movimientoId));
	}

	@Override
	public List<MovimientoDto> listaMovimiento() {
		List<Movimiento> movimientos = movimientoRepository.findAll();
		return movimientos.stream().map((emp) -> MovimientoMapper.toDto(emp)).collect(Collectors.toList());
	}

	@Override
	public void deleteMovimiento(Integer cuentaId) {
		movimientoRepository.deleteById(cuentaId);	
	}



}
