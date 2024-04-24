package br.com.canaldorubao.model.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cliente {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("telefone")
	private String telefone;
	
	
	public Cliente(Long id, String nome, String email, String telefone) {
		this.id =  id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Cliente() {
		
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	

}
