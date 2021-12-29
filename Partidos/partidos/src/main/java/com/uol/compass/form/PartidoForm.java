package com.uol.compass.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uol.compass.modelo.Ideologia;
import com.uol.compass.modelo.Partido;
import com.uol.compass.repository.PartidoRepository;

public class PartidoForm {

	private Partido idPartido;
	@NotBlank(message = "Este campo é obrigatório!")
	private String nomeDoPartido;
	@NotBlank(message = "Este campo é obrigatório!")
	private String sigla;
	@NotNull(message = "Este campo é obrigatório!")
	private Ideologia ideologia;
	@NotNull(message = "Este campo é obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataFundacao;

	public PartidoForm() {

	}

	public PartidoForm(Partido idPartido, String nomeDoPartido, String sigla, Ideologia ideologia,
			LocalDate dataFundacao) {

		this.idPartido = idPartido;
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataFundacao = dataFundacao;
	}

	public Partido getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Partido idPartido) {
		this.idPartido = idPartido;
	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Partido converter() {
		return new Partido(this.nomeDoPartido, this.sigla, this.ideologia, this.dataFundacao);
	}

	public Partido atualiza(Partido id, PartidoRepository partidoRepository) {
		Partido partido = partidoRepository.getOne(id);

		partido.setNomeDoPartido(this.nomeDoPartido);
		partido.setSigla(this.sigla);
		partido.setIdeologia(this.ideologia);
		partido.setDataFundacao(this.dataFundacao);

		return partido;
	}

}
