package com.prueba.crud.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.crud.dto.MovimientoDto;


public interface ServicioMovimiento {

	MovimientoDto createMovimiento(MovimientoDto movimientoDto);	
	MovimientoDto updateMovimiento(MovimientoDto movimientoDto);
	MovimientoDto getMovimientoById(Integer cuentaId);
    List<MovimientoDto> listaMovimiento();
    void deleteMovimiento(Integer cuentaId);
    
}
