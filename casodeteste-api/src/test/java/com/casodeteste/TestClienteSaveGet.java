package com.casodeteste;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.casodeteste.dto.ResponseClienteDTO;
import com.casodeteste.service.ClienteService;

@SpringBootTest
class TestClienteSaveGet {
	
	@Autowired
	private ClienteService service;

	@Test
	public void saveCliente() {
		
		ResponseClienteDTO dto = new ResponseClienteDTO();
		dto.setDocumento("101.150.976-50");
		dto.setNome("Nielter Brenno");
		assertThat(service.saveCliente(dto).equals("Cliente cadastrado com Sucesso!")).isTrue();
	}
	
	@Test
	public void saveErroClienteDocumentoInvalido() {
		
		ResponseClienteDTO dto = new ResponseClienteDTO();
		dto.setNome("Nielter Brenno");
		dto.setDocumento("101.150.976-508");
		assertThat(service.saveCliente(dto).equals("Documento Inválido!")).isTrue();
	}

}
