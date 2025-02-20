package com.prueba.crud.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.crud.entidades.Cuenta;
import com.prueba.crud.entidades.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

	public List<Movimiento> findAllByOrderByFechaDesc();
	
    @Query("select m from Movimiento m where cuenta =: cuenta")
	List<Movimiento> findByCuenta(Cuenta cuenta);
	
  
    @Query("SELECT "
            + " (movimiento) from Movimiento movimiento "
            + " INNER JOIN  "
            + "movimiento.cuenta cuenta  "
            + "WHERE "
            + "cuenta.id = :cuentaId")
    List<Movimiento> fecthByCuentaId(long cuentaId);
		
	
    
    @Query("SELECT "
            + " (movimiento) from Movimiento movimiento "
            + " INNER JOIN  "
            + "movimiento.cuenta cuenta  "
            + "WHERE "
            + "cuenta.numero = :numeroCuenta")
    List<Movimiento> fecthByNumeroCuenta(String numeroCuenta);
		
    

    @Query("SELECT "
            + " (movimiento) from Movimiento movimiento "
            + " INNER JOIN  "
            + "movimiento.cuenta.cliente cliente  "
            + "WHERE "
            + "cliente.id = :clienteId  and movimiento.fecha BETWEEN :startDate AND :endDate")
    List<Movimiento> fecthMovimientoBetweenDatesAndClientID(@Param("startDate")Date startDate,@Param("endDate")Date endDate, long clienteId);
    

}
