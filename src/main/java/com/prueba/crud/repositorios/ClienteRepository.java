package com.prueba.crud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


import com.prueba.crud.entidades.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends R2dbcRepository<Cliente, Integer> {

	//List<Cliente> findByEmailContaining(String title);
		
//	  @Query("SELECT "
//	            + "DISTINCT (customer) from Cliente customer "
//	            + "WHERE "
//	            + "identificacion = :identification")
//	  List<Cliente> findClienteByIdentification(String identification);
//
//	  @Query("SELECT "
//	            + "DISTINCT (cliente) from Cliente cliente "
//	            + "JOIN FETCH "
//	            + "cliente.cuentas  "
//	            + "WHERE "
//	            + "cliente.id = :clienteId")
//	 Mono<Cliente> fetchCliente(long clienteId);
	 
}
