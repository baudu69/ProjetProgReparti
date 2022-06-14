package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Obtenir;
import fr.polytech.projet.projetapi.model.ObtenirId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObtenirRepository extends JpaRepository<Obtenir, ObtenirId> {
}