package com.uol.compass.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uol.compass.modelo.Associado;
import com.uol.compass.modelo.CargoPolitico;


public interface AssociadoRepository extends JpaRepository<Associado, Long> {

	List<Associado> findAllByCargoPolitico(CargoPolitico cargo);

	List<Associado> findAllByPartidoId(Long id);

	Associado findByIdAssociado(Long idAssociado);

}
