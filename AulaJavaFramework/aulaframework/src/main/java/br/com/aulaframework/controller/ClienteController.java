package br.com.aulaframework.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.aulaframework.model.Cliente;
import br.com.aulaframework.repository.ClienteRepository;

@Named
@ViewScoped
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private List<Cliente> clientes;
	
	private Cliente cliente;

	private boolean modoEdicao = false;
	
	@PostConstruct
	public void init() {
		setClientes(clienteRepository.findAll());
		cliente = new Cliente();
	}
	
	public void salvar() {
		clienteRepository.save(cliente);
		if(!modoEdicao) {
			clientes.add(cliente);
		}
		cliente = new Cliente();
		modoEdicao=false;
	}
	
	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
		modoEdicao=false;
	}
	
	public void cancelar() {
		cliente = new Cliente();
		modoEdicao=false;
	}
	
	public void editar(Cliente cliente) {
		setCliente(cliente);
		modoEdicao=true;
	}
		
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
