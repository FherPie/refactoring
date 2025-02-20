package com.prueba.crud.mapper;


import com.prueba.crud.dto.MovimientoDto;
import com.prueba.crud.entidades.Movimiento;

public class MovimientoMapper {
	
	public static Movimiento toEntity(MovimientoDto dto) {
		return Movimiento.builder().movimientoId(dto.getMovimientoId())
				.tipo(dto.getTipo())
				.valor(dto.getValor())
				.fecha(dto.getFecha())
				.build();
	};
	
	public static MovimientoDto toDto(Movimiento entity) {
		return MovimientoDto.builder().movimientoId(entity.getMovimientoId())
				.tipo(entity.getTipo())
				.valor(entity.getValor())
				.fecha(entity.getFecha())
				.build();
	};

}
