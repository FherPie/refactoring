package com.prueba.crud.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.crud.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	//List<Cliente> findByEmailContaining(String title);
		
	  @Query("SELECT "
	            + "DISTINCT (customer) from Cliente customer "
	            + "WHERE "
	            + "identificacion = :identification")
	 List<Cliente> findClienteByIdentification(String identification);
	  
	  
	  @Query("SELECT "
	            + "DISTINCT (cliente) from Cliente cliente "
	            + "JOIN FETCH "
	            + "cliente.cuentas  "
	            + "WHERE "
	            + "cliente.id = :clienteId")
	 Cliente fetchClienteWithCuentasByIdentification(long clienteId);
	 
}
