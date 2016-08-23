package com.apispring.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Users implements Serializable {

	private static final long serialVersionUID = 8420454256842015493L;

	private String ativo;
	@Id
	private String id;
	private String nome;

	public Users() {
	}

	public String getAtivo() {
		return ativo;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
