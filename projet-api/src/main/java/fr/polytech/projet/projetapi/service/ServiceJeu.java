package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.Jeu;
import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.repository.JeuRepository;
import fr.polytech.projet.projetapi.repository.MissionJeuRepository;
import fr.polytech.projet.projetapi.repository.MissionRepository;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceJeu {
    private final JeuRepository jeuRepository;
    private final MissionJeuRepository missionJeuRepository;
    private final MissionRepository missionRepository;


    public ServiceJeu(JeuRepository jeuRepository, MissionJeuRepository missionJeuRepository, MissionRepository missionRepository) {
        this.jeuRepository = jeuRepository;
        this.missionJeuRepository = missionJeuRepository;
        this.missionRepository = missionRepository;
    }

    /**
     * @return List of all jeux
     */
    public List<Jeu> findAll() {
        return jeuRepository.findAll();
    }

    public Optional<Jeu> findById(int id) {
        return jeuRepository.findById(id);
    }

    public List<Mission> findMissionsByJeuId(int idJeu) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        return this.missionJeuRepository.findById_IdJeu(idJeu)
                .stream()
                .map(missionJeu -> this.missionRepository.findById(missionJeu.getId().getIdMission()))
                .map(mission -> mission.orElseThrow(NotExistException::new))
                .toList();
    }
}
