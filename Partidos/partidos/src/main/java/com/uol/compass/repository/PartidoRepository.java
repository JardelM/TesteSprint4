package com.uol.compass.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uol.compass.modelo.Ideologia;
import com.uol.compass.modelo.Partido;



public interface PartidoRepository extends JpaRepository<Partido, Long> {

	List<Partido> findAllByIdeologia(Ideologia ideologia);

	Optional<Partido> findById(Long idPartido);

}
