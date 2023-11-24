package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class ContatoMedico {

	private int id;
	@NotBlank private int idMedico;
	@NotBlank private int ddi;
	@NotBlank private int ddd;
	@NotBlank private Long telefone;
	
	public ContatoMedico() {}

	public ContatoMedico(int id, @NotBlank int idMedico, @NotBlank int ddi, @NotBlank int ddd,
			@NotBlank Long telefone) {
		this.id = id;
		this.idMedico = idMedico;
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

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
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
