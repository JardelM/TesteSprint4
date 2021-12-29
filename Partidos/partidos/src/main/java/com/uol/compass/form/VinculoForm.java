package com.uol.compass.form;

import java.util.Optional;

import com.uol.compass.modelo.Associado;
import com.uol.compass.modelo.Partido;
import com.uol.compass.repository.AssociadoRepository;
import com.uol.compass.repository.PartidoRepository;

public class VinculoForm {

	private Long idAssociado;
	private Long idPartido;

	public Long getIdAssociado() {
		return idAssociado;
	}

	public void setIdAssociado(Long idAssociado) {
		this.idAssociado = idAssociado;
	}

	public Long getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}

	public Associado associa(AssociadoRepository associadoRepository, PartidoRepository partidoRepository,
			VinculoForm testeForm) {

		Long idAssociado = testeForm.getIdAssociado();
		Long idPartido = testeForm.getIdPartido();

		Optional<Associado> associado = associadoRepository.findById(idAssociado);

		Partido partido = partidoRepository.findById(idPartido);
		Associado associadoParaVincular;
		

		if (associado.isPresent()) {
				
			associadoParaVincular = associado.get();
			associadoParaVincular.setPartido(partido);
			return associadoParaVincular;

		return null;

	}

	public Associado remove(AssociadoRepository associadoRepository, PartidoRepository partidoRepository,
			VinculoForm form) {

		Long idAssociado = form.getIdAssociado();
		Long idPartido = form.getIdPartido();

		Optional<Associado> associado = associadoRepository.findById(idAssociado);

		if (associado.isPresent()) {
			Optional<Partido> partido = partidoRepository.findById(idPartido);

			if (partido.isPresent()) {
				Associado associadoParaRemover = associado.get();
				associadoParaRemover.setPartido(null);
				return associadoParaRemover;
			}

		}

		return null;
	}

}
