package com.prueba.crud.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("movimientos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {

	@Id
	private Integer movimientoId;
	
	@Column(name = "tipoMovimiento")
    private String tipo;
	
	@Column(name = "valor")
    private Double valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;
	

	private Integer cuentaId;
	
}
