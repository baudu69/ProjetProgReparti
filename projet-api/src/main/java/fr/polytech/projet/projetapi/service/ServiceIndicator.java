package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.model.Indicator;
import fr.polytech.projet.projetapi.repository.IndicatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceIndicator {
    private final IndicatorRepository indicatorRepository;

    public ServiceIndicator(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }

    /**
     * @param idAction id de l'action
     * @return Liste des indicateurs de l'action
     */
    public List<Indicator> getAllIndicatorsOfAnAction(int idAction) {
        return this.indicatorRepository.findByIdAction(idAction);
    }

    public void addIndicatorToAnAction(Indicator indicator) {
        this.indicatorRepository.save(indicator);
    }
}
