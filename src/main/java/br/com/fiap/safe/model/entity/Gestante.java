package br.com.fiap.safe.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public class Gestante {

	private int id;
	@NotBlank private String nome;
	@NotBlank private Long cpf;
	@NotBlank @Past private LocalDate dataNascimento;
	@NotBlank private String email;
	@NotBlank private String senha;
	
	public Gestante() {}

	public Gestante(int id, @NotBlank String nome, @NotBlank Long cpf, @NotBlank @Past LocalDate dataNascimento,
			@NotBlank String email, @NotBlank String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
