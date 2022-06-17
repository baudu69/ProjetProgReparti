package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectifRepository extends JpaRepository<Objectif, Integer> {
	List<Objectif> findByIdMission(Integer idMission);
}