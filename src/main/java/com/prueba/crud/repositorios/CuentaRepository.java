package com.prueba.crud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.crud.entidades.Cliente;
import com.prueba.crud.entidades.Cuenta;

@Repository
public interface CuentaRepository extends R2dbcRepository<Cuenta, Integer> {

//    @Query("select c from Cuenta c where cliente =: cliente")
//	List<Cuenta> findByCliente(Cliente cliente);
//
//
//    @Query("SELECT "
//            + "DISTINCT (cuenta) from Cuenta cuenta "
//            + " INNER JOIN  "
//            + "cuenta.cliente cliente  "
//            + "WHERE "
//            + "cliente.id = :clienteId")
//    List<Cuenta> fecthByCliente(long clienteId);
//
//
//    @Query("SELECT "
//            + "DISTINCT (cuenta) from Cuenta cuenta "
//            + " INNER JOIN  "
//            + "cuenta.cliente cliente  ")
//    List<Cuenta> fecthCuentas();
//
    
    
    List<Cuenta> findAllByNumero(String numeroCuenta);
    
    
    //TO DO CUENTA CON TODOS LOS MOVIMIENTOS
//	  @Query("SELECT "
//	            + "DISTINCT (cliente) from Cliente cliente "
//	            + "JOIN FETCH "
//	            + "cliente.cuentas  "
//	            + "WHERE "
//	            + "cliente.id = :clienteId")
//	 Cliente fetchClienteWithCuentasByIdentification(long clienteId);
//	
}
