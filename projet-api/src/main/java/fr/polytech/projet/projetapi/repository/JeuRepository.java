package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
}