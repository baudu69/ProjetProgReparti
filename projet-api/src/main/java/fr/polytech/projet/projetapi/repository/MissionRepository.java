package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
}