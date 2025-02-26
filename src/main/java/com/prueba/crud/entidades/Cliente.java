package com.prueba.crud.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clienteId;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name = "estado")
    private String estado;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cuenta> cuentas;
	
	
	 @Builder
	 public Cliente(String nombre, String genero, int edad, String identificacion, String direccion, String telefono, 
			 String contrasena, Integer clienteId, String estado) {
	       super( nombre, genero,  edad,  identificacion,  direccion, telefono);
	        this.clienteId = clienteId;
	        this.contrasena = contrasena;
	        this.estado = estado;
	    }
	

	
}
