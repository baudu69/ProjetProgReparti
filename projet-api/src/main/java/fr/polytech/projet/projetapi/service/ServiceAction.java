package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAction {
    private final ActionRepository actionRepository;

    public ServiceAction(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    /**
     * @return List of all actions
     */
    public List<Action> findAll() {
        return actionRepository.findAll();
    }
}
