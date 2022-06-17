package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.AlreadyExistException;
import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.Inscription;
import fr.polytech.projet.projetapi.model.Jeu;
import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.repository.*;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceJeu {
    private final JeuRepository jeuRepository;
    private final MissionJeuRepository missionJeuRepository;
    private final MissionRepository missionRepository;
    private final InscriptionRepository inscriptionRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ServiceJeu(JeuRepository jeuRepository, MissionJeuRepository missionJeuRepository, MissionRepository missionRepository, InscriptionRepository inscriptionRepository, UtilisateurRepository utilisateurRepository) {
        this.jeuRepository = jeuRepository;
        this.missionJeuRepository = missionJeuRepository;
        this.missionRepository = missionRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.utilisateurRepository = utilisateurRepository;
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

    /**
     * Inscrit un utilisateur à un jeu
     *
     * @param idJeu  ID du jeu
     * @param idUser ID de l'apprenant
     */
    public void inscriptionApprenantToAJeu(int idJeu, int idUser) {
        if (!this.inscriptionRepository.findByUtilisateur_IdAndJeu_Id(idUser, idJeu).isEmpty()) {
            throw new AlreadyExistException();
        }
        Inscription inscription = new Inscription();
        inscription.setUtilisateur(this.utilisateurRepository.findById(idUser).orElseThrow(NotExistException::new));
        inscription.setJeu(this.jeuRepository.findById(idJeu).orElseThrow(NotExistException::new));
        inscription.setDate(LocalDate.now());
        this.inscriptionRepository.save(inscription);
    }
}
