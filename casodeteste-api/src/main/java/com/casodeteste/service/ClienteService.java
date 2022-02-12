package com.casodeteste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casodeteste.dto.ResponseClienteDTO;
import com.casodeteste.dto.TipoPessoa;
import com.casodeteste.model.Cliente;
import com.casodeteste.repository.ClienteRepository;

import lombok.extern.log4j.Log4j2;


/** 
 * Classe de serviço, para salvar e consultar cliente
 * 
 * @author Nielter Brenno
 * @since 12/02/2022	
 */

@Service
@Log4j2
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public String saveCliente(ResponseClienteDTO dto){

		try {
			if(Objects.nonNull(dto)) {							
				//Crio o cliente
				Cliente cliente = new Cliente();
				//Verifico pelo documento se já existe
				String documento = dto.getDocumento().replaceAll("[./-]", "");
				Optional<Cliente> opCliente = repository.findByDocumento(documento);
				
				if(opCliente.isPresent()) {
					//Existindo atribuo
					cliente = opCliente.get();
				} else {
					//Caso contrário, crio novo
					cliente.setId(UUID.randomUUID());					
					cliente.setTipoPessoa(validaDocumento(documento));
					cliente.setDocumento(documento);
				}
				cliente.setNome(dto.getNome());
				//Salva no banco
				repository.save(cliente);
			} else throw new RuntimeException((String) "Não possui dados para salvar o cliente!"); 
			//Retorno o OK
			return "Cliente cadastrado com Sucesso!";
		} catch (Exception e) {
			return e.getMessage(); 
		}
	}

	public List<ResponseClienteDTO> getByName(String nome){
		List<ResponseClienteDTO> lista = new ArrayList<ResponseClienteDTO>();
		try {
			
			//Faço a consulta pelo nome, podendo ter 1 ou mais
			List<Cliente> clientes = repository.findAllByNome(nome);

			//retornando, atribuo no DTO de retorno
			clientes.stream().forEach(c -> {
				ResponseClienteDTO dto = new ResponseClienteDTO();
				dto.setNome(c.getNome());				 
				dto.setTipoPessoa(c.getTipoPessoa().getDescricao());
				dto.setDocumento(c.getDocumento());				 
				lista.add(dto);
			});

		} catch (Exception e) {
			log.error("Erro ao consultar cliente pelo nome");
			throw new RuntimeException((String) "Erro ao consultar cliente pelo nome");
		}
		return lista;
	}

	public TipoPessoa validaDocumento(String documento) {
		
		//validar o tipo de documento informado
		if(documento.length() == 11) {
			return TipoPessoa.PF;
		} else if(documento.length() == 14) {
			return TipoPessoa.PJ;					
		} else throw new RuntimeException((String) "Documento Inválido!");


	}

}
