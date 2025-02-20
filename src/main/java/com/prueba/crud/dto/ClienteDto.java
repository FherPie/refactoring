package com.prueba.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

	private Integer clienteId;
	private String contrasena;
    private String estado;
	private String nombre;
    private String genero;
	private int edad;
	private String identificacion;
	private String direccion;
	private String telefono;
}
