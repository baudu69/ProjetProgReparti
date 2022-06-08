package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.Inscription;
import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.model.Utilisateur;
import fr.polytech.projet.projetapi.projection.InscriptionInfo;
import fr.polytech.projet.projetapi.repository.InscriptionRepository;
import fr.polytech.projet.projetapi.repository.MissionRepository;
import fr.polytech.projet.projetapi.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMission {
    private final MissionRepository missionRepository;
    private final InscriptionRepository inscriptionRepository;
    private final UtilisateurRepository utilisateurRepository;

    public ServiceMission(MissionRepository missionRepository, ServiceApprenant serviceApprenant, InscriptionRepository inscriptionRepository, UtilisateurRepository utilisateurRepository) {
        this.missionRepository = missionRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    public Optional<Mission> getMissionById(int id) {
        return missionRepository.findById(id);
    }

    public List<InscriptionInfo> getMissionsByUserId(int idUser) {
        return this.inscriptionRepository.findByUtilisateur_Id(idUser);
    }

    /**
     * @param idUser id utilisateur
     * @return liste des missions où l'utilisateur est n'est pas inscrit
     */
    public List<Mission> getMissionsNonInscritsByUserId(int idUser) {
        List<Integer> idMissionsInscrites = this.getMissionsByUserId(idUser)
                .stream()
                .map(InscriptionInfo::getMission)
                .map(InscriptionInfo.MissionInfo::getId)
                .toList();
        return this.missionRepository.findByIdNotIn(idMissionsInscrites);
    }

    /**
     * Inscrit un utilisateur à une mission
     *
     * @param idUser    id utilisateur
     * @param idMission id mission
     */
    public void inscription(int idUser, int idMission) {
        Utilisateur user = utilisateurRepository.findById(idUser).orElseThrow(NotExistException::new);
        Mission mission = missionRepository.findById(idMission).orElseThrow(NotExistException::new);
        Inscription inscription = new Inscription();
        inscription.setUtilisateur(user);
        inscription.setMission(mission);
        inscription.setDate(LocalDate.now());
        this.inscriptionRepository.save(inscription);
    }
}
