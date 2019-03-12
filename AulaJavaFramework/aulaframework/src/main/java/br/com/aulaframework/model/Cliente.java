package br.com.aulaframework.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	
	private String email;

	
	public Cliente() {
		// TODO Auto-generated constructor stub
	} 
	
	public Cliente(String nome, String email) {
		
		this.nome=nome;
		this.email=email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
