package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    List<Action> findByIdNotIn(Collection<Integer> ids);
}