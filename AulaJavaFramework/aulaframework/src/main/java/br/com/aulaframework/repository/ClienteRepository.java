package br.com.aulaframework.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aulaframework.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query("select cli from Cliente cli where cli.email =:email")
	public Cliente buscaPorEmail(@Param("email") String email);
	
	@Query("Select cli from Cliente cli")
	public List<Cliente> buscarTodos();
}
