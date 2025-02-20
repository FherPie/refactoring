package com.prueba.crud.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDto {

	private Integer movimientoId;
    private String tipo;
    private Double valor;
	private Date fecha;
	private Integer cuentaId;
	private String mensaje;
}
