package com.prueba.crud.mapper;


import com.prueba.crud.dto.ClienteDto;
import com.prueba.crud.entidades.Cliente;

public class ClienteMapper {
	
	public static Cliente toEntity(ClienteDto dto) {
		return Cliente.builder().clienteId(dto.getClienteId())
				.contrasena(dto.getContrasena())
				.estado(dto.getEstado())
				.nombre(dto.getNombre())
				.genero(dto.getGenero())
				.edad(dto.getEdad())
				.identificacion(dto.getDireccion())
				.telefono(dto.getTelefono())	
				.build();
	};
	
	public static ClienteDto toDto(Cliente entity) {
		return ClienteDto.builder().clienteId(entity.getClienteId())
				.contrasena(entity.getContrasena())
				.estado(entity.getEstado())
				.nombre(entity.getNombre())
				.genero(entity.getGenero())
				.edad(entity.getEdad())
				.identificacion(entity.getDireccion())
				.telefono(entity.getTelefono())	
				.build();
	};
	

}
