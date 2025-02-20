package com.prueba.crud.implementacion;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.crud.dto.CuentaDto;
import com.prueba.crud.entidades.Cliente;
import com.prueba.crud.entidades.Cuenta;
import com.prueba.crud.interfaces.ServicioCuenta;
import com.prueba.crud.mapper.CuentaMapper;
import com.prueba.crud.repositorios.ClienteRepository;
import com.prueba.crud.repositorios.CuentaRepository;

@Service
public class ServicioCuentaImpl implements ServicioCuenta {

	@Autowired
	CuentaRepository cuentaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public CuentaDto createCuenta(CuentaDto cuentaDto) {
		Cuenta cuenta = null;
		try {
			Optional<Cliente> cliente = clienteRepository.findById(cuentaDto.getClienteId());
			if (cliente.isPresent()) {
				cuenta = CuentaMapper.toEntity(cuentaDto);
				cuenta.setCliente(cliente.get());
				cuenta=cuentaRepository.save(cuenta);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return CuentaMapper.toDto(cuenta);
	}

	@Override
	public CuentaDto updateCuenta(CuentaDto cuentaDto) {
		Cuenta cuenta =null;
		try {
			 cuenta =  CuentaMapper.toEntity(cuentaDto);
			cuenta=cuentaRepository.save(cuenta);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		return CuentaMapper.toDto(cuenta);
	}

	@Override
	public CuentaDto getClienteById(Integer cuentaId) {
	   return CuentaMapper.toDto(cuentaRepository.getReferenceById(cuentaId));
	}

	@Override
	public List<CuentaDto> listaCuenta() {
		List<Cuenta> cuentas = cuentaRepository.findAll();
		return cuentas.stream().map((emp) -> CuentaMapper.toDto(emp)).collect(Collectors.toList());
	}

	@Override
	public void deleteCuenta(Integer cuentaId) {
		cuentaRepository.deleteById(cuentaId);		
	}
	


}
