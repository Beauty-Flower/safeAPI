package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Medico {

	private int id;
	@NotBlank private String nome;
	@NotBlank private Long crm;
	@NotBlank private String email;
	@NotBlank private String senha;
	
	public Medico() {}
	
	public Medico(int id, @NotBlank String nome, @NotBlank Long crm, @NotBlank String email, @NotBlank String senha) {
		this.id = id;
		this.nome = nome;
		this.crm = crm;
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

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
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
