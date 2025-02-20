package com.prueba.crud.interfaces;

import java.util.List;

import com.prueba.crud.dto.ClienteDto;

public interface ServicioCliente {
	
	ClienteDto createCliente(ClienteDto clienteDto);	
	ClienteDto updateCliente(ClienteDto clienteDto);
	ClienteDto getClienteById(Integer employeeId);
    List<ClienteDto> listaCliente();
    void deleteCliente(Integer clienteId);
}
