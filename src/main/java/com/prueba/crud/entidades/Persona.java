package com.prueba.crud.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Persona {

	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(length=20)
    private String genero;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "identificacion")
	private String identificacion;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	
	
}
