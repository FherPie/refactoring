package com.prueba.crud.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.crud.entidades.Cuenta;
import com.prueba.crud.entidades.Movimiento;
import reactor.core.publisher.Flux;

@Repository
public interface MovimientoRepository extends R2dbcRepository<Movimiento, Integer> {

//	public List<Movimiento> findAllByOrderByFechaDesc();
//
//    @Query("select m from Movimiento m where cuenta =: cuenta")
//    Flux<Movimiento> findByCuenta(Cuenta cuenta);
//
//
//    @Query("SELECT "
//            + " (movimiento) from Movimiento movimiento "
//            + " INNER JOIN  "
//            + "movimiento.cuenta cuenta  "
//            + "WHERE "
//            + "cuenta.id = :cuentaId")
//    Flux<Movimiento> fecthByCuentaId(long cuentaId);
//
//
//
//    @Query("SELECT "
//            + " (movimiento) from Movimiento movimiento "
//            + " INNER JOIN  "
//            + "movimiento.cuenta cuenta  "
//            + "WHERE "
//            + "cuenta.numero = :numeroCuenta")
//    Flux<Movimiento> fecthByNumeroCuenta(String numeroCuenta);
		
    
//
//    @Query("SELECT "
//            + " (movimiento) from Movimiento movimiento "
//            + " INNER JOIN  "
//            + "movimiento.cuenta.cliente cliente  "
//            + "WHERE "
//            + "cliente.id = :clienteId  and movimiento.fecha BETWEEN :startDate AND :endDate")
//    Flux<Movimiento> fecthMovimientoBetweenDatesAndClientID(@Param("startDate")Date startDate,@Param("endDate")Date endDate, long clienteId);
//

}
