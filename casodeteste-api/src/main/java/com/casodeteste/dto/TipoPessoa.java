package com.casodeteste.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoPessoa {
	PJ("Pessoa Física"),
	PF("Pessoa Jurídica"),
	INVALIDO("Documento Inválido");
	
	private String descricao;
}
