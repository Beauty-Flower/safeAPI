package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class EnderecoGestante {

	private int id;
	@NotBlank private int idGestante;
	private String nomeLogradouro;
	@NotBlank private int numeroLogradouro;
	@NotBlank private String cidade;
	@NotBlank private String bairro;
	@NotBlank private String estado;
	
	public EnderecoGestante() {}

	public EnderecoGestante(int id, @NotBlank int idGestante, String nomeLogradouro, @NotBlank int numeroLogradouro,
			@NotBlank String cidade, @NotBlank String bairro, @NotBlank String estado) {
		this.id = id;
		this.idGestante = idGestante;
		this.nomeLogradouro = nomeLogradouro;
		this.numeroLogradouro = numeroLogradouro;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
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

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
