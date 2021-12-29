package com.uol.compass.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uol.compass.modelo.Associado;
import com.uol.compass.modelo.CargoPolitico;
import com.uol.compass.modelo.Partido;
import com.uol.compass.modelo.Sexo;

public class AssociadoDTO {

	private Long idAssociado;
	private String nome;
	private CargoPolitico cargoPolitico;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	private Sexo sexo;
	@ManyToOne
	@JoinColumn
	private Partido partido;

	public AssociadoDTO(Associado associado) {

		this.idAssociado = associado.getIdAssociado();
		this.nome = associado.getNome();
		this.cargoPolitico = associado.getCargoPolitico();
		this.dataNascimento = associado.getDataNascimento();
		this.sexo = associado.getSexo();
		this.partido = associado.getPartido();

	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public String getNome() {
		return nome;
	}

	public CargoPolitico getCargoPolitico() {
		return cargoPolitico;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public static List<AssociadoDTO> converter(List<Associado> associado) {
		return associado.stream().map(AssociadoDTO::new).collect(Collectors.toList());

	}

}
