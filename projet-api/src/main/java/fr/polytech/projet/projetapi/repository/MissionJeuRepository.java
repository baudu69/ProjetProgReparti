package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.MissionJeu;
import fr.polytech.projet.projetapi.model.MissionJeuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionJeuRepository extends JpaRepository<MissionJeu, MissionJeuId> {
}