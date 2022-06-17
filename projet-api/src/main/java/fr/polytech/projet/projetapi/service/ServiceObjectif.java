package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Objectif;
import fr.polytech.projet.projetapi.repository.ActionRepository;
import fr.polytech.projet.projetapi.repository.ObjectifActionRepository;
import fr.polytech.projet.projetapi.repository.ObjectifRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceObjectif {
	private final ObjectifRepository objectifRepository;
	private final ObjectifActionRepository objectifActionRepository;
	private final ActionRepository actionRepository;

	public ServiceObjectif(ObjectifRepository objectifRepository, ObjectifActionRepository objectifActionRepository, ActionRepository actionRepository) {
		this.objectifRepository = objectifRepository;
		this.objectifActionRepository = objectifActionRepository;
		this.actionRepository = actionRepository;
	}

	public List<Objectif> findAll() {
		return this.objectifRepository.findAll();
	}

	/**
	 * @param missionId ID de la mission
	 * @return Liste des objectifs de la mission
	 */
	public List<Objectif> getObjectifsOfAMission(int missionId) {
		return objectifRepository.findByIdMission(missionId);
	}

	/**
	 * @param objectifId ID de l'objectif
	 * @return Liste des actiions de l'objectif
	 */
	public List<Action> getActionOfAnObjectif(int objectifId) {
		return objectifActionRepository.findById_IdObjectif(objectifId)
				.stream()
				.map(objectifAction -> objectifAction.getId().getIdAction())
				.map(actionId -> actionRepository.findById(actionId).orElseThrow(NotExistException::new))
				.toList();
	}
}
