package com.prueba.crud.mapper;


import com.prueba.crud.dto.CuentaDto;
import com.prueba.crud.entidades.Cuenta;

public class CuentaMapper {
	
	public static Cuenta toEntity(CuentaDto dto) {
		return Cuenta.builder().cuentaId(dto.getCuentaId())
				.numero(dto.getNumero())
				.tipo(dto.getTipo())
				.saldo(dto.getSaldo())
				.estado(dto.getEstado())
				.build();
	};
	
	public static CuentaDto toDto(Cuenta entity) {
		return CuentaDto.builder().cuentaId(entity.getCuentaId())
				.numero(entity.getNumero())
				.tipo(entity.getTipo())
				.saldo(entity.getSaldo())
				.estado(entity.getEstado())
				.build();
	};
	

}
