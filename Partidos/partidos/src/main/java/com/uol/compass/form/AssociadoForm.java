package com.uol.compass.form;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uol.compass.modelo.Associado;
import com.uol.compass.modelo.CargoPolitico;
import com.uol.compass.modelo.Partido;
import com.uol.compass.modelo.Sexo;
import com.uol.compass.repository.AssociadoRepository;

public class AssociadoForm {

	private Long idAssociado;
	@NotBlank(message = "Este campo é obrigatório!")
	private String nome;
	private CargoPolitico cargoPolitico;
	@NotNull(message = "Este campo é obrigatório!")
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	private Sexo sexo;
	@ManyToOne
	@JoinColumn
	private Partido partido;

	public AssociadoForm() {

	}

	public AssociadoForm(Long idAssociado, String nome, CargoPolitico cargoPolitico, LocalDate dataNascimento,
			Sexo sexo, Partido partido) {

		this.idAssociado = idAssociado;
		this.nome = nome;
		this.cargoPolitico = cargoPolitico;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.partido = partido;
	}

	public Long getIdAssociado() {
		return idAssociado;
	}

	public Partido getPartido() {
		return partido;
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

	public Associado converter(AssociadoRepository associadoRepository) {
		return new Associado(nome, cargoPolitico, dataNascimento, sexo, partido);
	}

	public Associado atualiza(Long id, AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.getOne(id);

		associado.setNome(this.nome);
		associado.setCargoPolitico(this.cargoPolitico);
		associado.setDataNascimento(this.dataNascimento);
		associado.setSexo(this.sexo);

		return associado;

	}
}
