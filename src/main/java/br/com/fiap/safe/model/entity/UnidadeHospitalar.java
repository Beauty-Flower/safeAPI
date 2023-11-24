package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class UnidadeHospitalar {

	private int id;
	@NotBlank private String nome;
	@NotBlank private String email;
	@NotBlank private String senha;
	
	public UnidadeHospitalar() {}

	public UnidadeHospitalar(int id, @NotBlank String nome, @NotBlank String email, @NotBlank String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
