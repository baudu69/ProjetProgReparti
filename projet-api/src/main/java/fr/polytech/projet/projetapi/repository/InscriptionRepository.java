package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
}