package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.InscriptionAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionActionRepository extends JpaRepository<InscriptionAction, Integer> {
}