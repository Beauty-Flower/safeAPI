package br.com.fiap.safe.model.entity;

import jakarta.validation.constraints.NotBlank;

public class Exame {

	private int id;
	@NotBlank private int idConsulta;
	@NotBlank private int pressaoSistolica;
	@NotBlank private int pressaoDiastolica;
	@NotBlank private int nivelGlicose;
	@NotBlank private int temperaturaCorporal;
	@NotBlank private int frequenciaCardiaca;
	
	public Exame() {}

	public Exame(int id, @NotBlank int idConsulta, @NotBlank int pressaoSistolica, @NotBlank int pressaoDiastolica,
			@NotBlank int nivelGlicose, @NotBlank int temperaturaCorporal, @NotBlank int frequenciaCardiaca) {
		this.id = id;
		this.idConsulta = idConsulta;
		this.pressaoSistolica = pressaoSistolica;
		this.pressaoDiastolica = pressaoDiastolica;
		this.nivelGlicose = nivelGlicose;
		this.temperaturaCorporal = temperaturaCorporal;
		this.frequenciaCardiaca = frequenciaCardiaca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getPressaoSistolica() {
		return pressaoSistolica;
	}

	public void setPressaoSistolica(int pressaoSistolica) {
		this.pressaoSistolica = pressaoSistolica;
	}

	public int getPressaoDiastolica() {
		return pressaoDiastolica;
	}

	public void setPressaoDiastolica(int pressaoDiastolica) {
		this.pressaoDiastolica = pressaoDiastolica;
	}

	public int getNivelGlicose() {
		return nivelGlicose;
	}

	public void setNivelGlicose(int nivelGlicose) {
		this.nivelGlicose = nivelGlicose;
	}

	public int getTemperaturaCorporal() {
		return temperaturaCorporal;
	}

	public void setTemperaturaCorporal(int temperaturaCorporal) {
		this.temperaturaCorporal = temperaturaCorporal;
	}

	public int getFrequenciaCardiaca() {
		return frequenciaCardiaca;
	}

	public void setFrequenciaCardiaca(int frequenciaCardiaca) {
		this.frequenciaCardiaca = frequenciaCardiaca;
	}	
}
