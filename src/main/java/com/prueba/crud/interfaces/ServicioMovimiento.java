package com.prueba.crud.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.crud.dto.MovimientoDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ServicioMovimiento {

	Mono<MovimientoDto> createMovimiento(MovimientoDto movimientoDto);
	Mono<MovimientoDto>  updateMovimiento(MovimientoDto movimientoDto);
	Mono<MovimientoDto>  getMovimientoById(Integer cuentaId);
    Flux<MovimientoDto> listaMovimiento();
	Mono<Void> deleteMovimiento(Integer cuentaId);
    
}
