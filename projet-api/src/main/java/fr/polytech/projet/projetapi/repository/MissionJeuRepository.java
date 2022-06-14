package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.MissionJeu;
import fr.polytech.projet.projetapi.model.MissionJeuId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionJeuRepository extends JpaRepository<MissionJeu, MissionJeuId> {
    List<MissionJeu> findById_IdJeu(Integer idJeu);
}