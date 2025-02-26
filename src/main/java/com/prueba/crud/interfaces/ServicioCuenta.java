package com.prueba.crud.interfaces;

import java.util.List;

import com.prueba.crud.dto.CuentaDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicioCuenta {

	Mono<CuentaDto> createCuenta(CuentaDto cuentaDto);
	Mono<CuentaDto> updateCuenta(CuentaDto cuentaDto);
	Mono<CuentaDto>  getClienteById(Integer cuentaId);
    Flux<CuentaDto> listaCuenta();
    void deleteCuenta(Integer cuentaId);
    
}
