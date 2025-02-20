package com.prueba.crud.implementacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.crud.dto.ClienteDto;
import com.prueba.crud.entidades.Cliente;
import com.prueba.crud.interfaces.ServicioCliente;
import com.prueba.crud.mapper.ClienteMapper;
import com.prueba.crud.repositorios.ClienteRepository;

@Service
public class ServicioClienteImpl implements ServicioCliente {

	@Autowired
	ClienteRepository clienteRepository;
	
	
	@Override
	public ClienteDto createCliente(ClienteDto clienteDto) {
		Cliente cliente=ClienteMapper.toEntity(clienteDto);
		cliente=clienteRepository.save(cliente);
		return ClienteMapper.toDto(cliente);
	}

	@Override
	public ClienteDto updateCliente(ClienteDto clienteDto) {
		Cliente cliente=ClienteMapper.toEntity(clienteDto);
		cliente=clienteRepository.save(cliente);
		return ClienteMapper.toDto(cliente);
	}

	@Override
	public ClienteDto getClienteById(Integer employeeId) {
	   return ClienteMapper.toDto(clienteRepository.getReferenceById(employeeId));
	}

	@Override
	public List<ClienteDto> listaCliente() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map((emp) -> ClienteMapper.toDto(emp)).collect(Collectors.toList());
	}

	@Override
	public void deleteCliente(Integer clienteId) {
		clienteRepository.deleteById(clienteId);		
	}

}
