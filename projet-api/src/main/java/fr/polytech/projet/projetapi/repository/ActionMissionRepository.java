package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.ActionMission;
import fr.polytech.projet.projetapi.model.ActionMissionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionMissionRepository extends JpaRepository<ActionMission, ActionMissionId> {
    List<ActionMission> findById_FkMission(Integer fkMission);

}