package com.casodeteste.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.casodeteste.dto.TipoPessoa;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
public @Data class Cliente {
	
	@Id
	private UUID id;
	
	private String nome;
	
	@NotNull
	private String documento;
	
	@Column(nullable = false)
	private TipoPessoa tipoPessoa;		
}
