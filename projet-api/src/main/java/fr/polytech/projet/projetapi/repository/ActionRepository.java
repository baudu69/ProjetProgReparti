package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
}