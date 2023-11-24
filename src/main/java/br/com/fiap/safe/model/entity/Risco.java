package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Risco {

	private int id;
	@NotBlank private int idExame;
	@NotBlank private String nivelRisco;
	
	public Risco() {}

	public Risco(int id, @NotBlank int idExame, @NotBlank String nivelRisco) {
		this.id = id;
		this.idExame = idExame;
		this.nivelRisco = nivelRisco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdExame() {
		return idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public String getNivelRisco() {
		return nivelRisco;
	}

	public void setNivelRisco(String nivelRisco) {
		this.nivelRisco = nivelRisco;
	}
}
