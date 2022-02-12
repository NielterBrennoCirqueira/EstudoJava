package com.casodeteste.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casodeteste.model.Cliente;



/**
 * Classe de Repository, para consultar dados do cliente
 * 
 * @author nielter.cirqueira
 * @since 12/02/2022
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

	Optional<Cliente> findByDocumento(String documento);
	
	List<Cliente> findAllByNome(String nome);
}
