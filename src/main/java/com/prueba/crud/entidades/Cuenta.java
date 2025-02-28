package com.prueba.crud.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("cuentas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
	
	@Id
	private Integer cuentaId;
	
	@Column(name = "numeroCuenta")
	private String numero;
	
	@Column(name = "tipoCuenta")
    private String tipo;
	
	@Column(name = "saldoInicial")
    private Double saldo;
	
	@Column(name = "estado")
    private String estado;

	private Integer clienteId;

	@MappedCollection(idColumn = "movimiento_Id")
	private List<Movimiento> movimientos;
	

}
