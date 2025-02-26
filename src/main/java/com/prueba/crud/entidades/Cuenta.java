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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cuentaId;
	
	@Column(name = "numeroCuenta")
	private String numero;
	
	@Column(name = "tipoCuenta")
    private String tipo;
	
	@Column(name = "saldoInicial")
    private Double saldo;
	
	@Column(name = "estado")
    private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cliente_Id")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="cuenta")
	private List<Movimiento> movimientos;
	

}
