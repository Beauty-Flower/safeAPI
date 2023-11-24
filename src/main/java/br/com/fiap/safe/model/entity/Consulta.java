package br.com.fiap.safe.model.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public class Consulta {

	private int id;
	@NotBlank private int idGestante;
	@NotBlank private int idUnidHospitalar;
	@NotBlank private int idMedico;
	@NotBlank @Future private LocalDateTime dataHora;
	
	public Consulta() {}

	public Consulta(int id, @NotBlank int idGestante, @NotBlank int idUnidHospitalar, @NotBlank int idMedico,
			@NotBlank @Future LocalDateTime dataHora) {
		this.id = id;
		this.idGestante = idGestante;
		this.idUnidHospitalar = idUnidHospitalar;
		this.idMedico = idMedico;
		this.dataHora = dataHora;
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

	public int getIdUnidHospitalar() {
		return idUnidHospitalar;
	}

	public void setIdUnidHospitalar(int idUnidHospitalar) {
		this.idUnidHospitalar = idUnidHospitalar;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
}
