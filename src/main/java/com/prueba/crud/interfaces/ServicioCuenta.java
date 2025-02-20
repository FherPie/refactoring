package com.prueba.crud.interfaces;

import java.util.List;

import com.prueba.crud.dto.CuentaDto;

public interface ServicioCuenta {

	CuentaDto createCuenta(CuentaDto cuentaDto);	
	CuentaDto updateCuenta(CuentaDto cuentaDto);
	CuentaDto getClienteById(Integer cuentaId);
    List<CuentaDto> listaCuenta();
    void deleteCuenta(Integer cuentaId);
    
}
