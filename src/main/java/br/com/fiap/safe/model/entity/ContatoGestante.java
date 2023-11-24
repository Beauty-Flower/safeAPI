package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class ContatoGestante {

	private int id;
	@NotBlank private int idGestante;
	@NotBlank private int ddi;
	@NotBlank private int ddd;
	@NotBlank private Long telefone;
	
	public ContatoGestante() {}

	public ContatoGestante(int id, @NotBlank int idGestante, @NotBlank int ddi, @NotBlank int ddd,
			@NotBlank Long telefone) {
		this.id = id;
		this.idGestante = idGestante;
		this.ddi = ddi;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdGestante() {
		return idGestante;
	}

	public void setIdGestante(int idGestante) {
		this.idGestante = idGestante;
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
}
