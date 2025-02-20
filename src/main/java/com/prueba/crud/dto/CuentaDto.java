package com.prueba.crud.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CuentaDto {

	
	private Integer cuentaId;
	private String numero;
    private String tipo;
    private Double saldo;
    private String estado;
	private Integer clienteId;
	//private List<MovimientoDto> movimientos;
	
}
