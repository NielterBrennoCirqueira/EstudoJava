package com.casodeteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casodeteste.dto.ResponseClienteDTO;
import com.casodeteste.service.ClienteService;




/**
 * Classe de Controller, receber requisições de Save e Get do Cliente
 * @author nielter.cirqueira
 * @since 12/02/2022
 */
@RestController
@RequestMapping("/cadastro")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping(value = "/cadastrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveCliente(@RequestBody ResponseClienteDTO cadastrar) {
		try {
			return service.saveCliente(cadastrar);
			
		} catch (Exception e) {
			return e.getMessage(); 
		}
	}
	
	@GetMapping(value = "/consultar/nome", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ResponseClienteDTO> getByName(@RequestParam("nome") String nome) {
		try {
			return service.getByName(nome);
		} catch (Exception e) {
			throw new RuntimeException((String) "Erro ao consultar cliente pelo nome");
		}
	}


}
