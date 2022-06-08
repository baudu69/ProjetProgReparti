package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
    List<Mission> findByIdNotIn(Collection<Integer> ids);
}