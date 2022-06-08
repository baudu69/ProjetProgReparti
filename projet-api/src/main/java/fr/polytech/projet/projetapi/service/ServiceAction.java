package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Action> findById(int id) {
        return actionRepository.findById(id);
    }

    public void ajouterAction(Action action) {
        actionRepository.save(action);
    }
}
