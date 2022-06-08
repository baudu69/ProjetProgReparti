package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.*;
import fr.polytech.projet.projetapi.projection.ActionWithoutIndicator;
import fr.polytech.projet.projetapi.projection.InscriptionInfo;
import fr.polytech.projet.projetapi.repository.*;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMission {
    private final MissionRepository missionRepository;
    private final InscriptionRepository inscriptionRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final ActionMissionRepository actionMissionRepository;
    private final ActionRepository actionRepository;

    public ServiceMission(MissionRepository missionRepository, ServiceApprenant serviceApprenant, InscriptionRepository inscriptionRepository, UtilisateurRepository utilisateurRepository, ActionMissionRepository actionMissionRepository, ActionRepository actionRepository) {
        this.missionRepository = missionRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.actionMissionRepository = actionMissionRepository;
        this.actionRepository = actionRepository;
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

    /**
     * @param idMission ID de la mission
     * @return Liste des actions de la mission
     */
    public List<ActionWithoutIndicator> findActionsByMissionId(int idMission) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        return this.actionMissionRepository.findById_FkMission(idMission)
                .stream()
                .map(actionMission -> this.actionRepository.findById(actionMission.getId().getFkAction()))
                .map(action -> action.orElseThrow(NotExistException::new))
                .map(action -> pf.createProjection(ActionWithoutIndicator.class, action))
                .toList();
    }

    /**
     * @param idMission ID de la mission
     * @return Liste des action qui n'appartiennent pas à la mission
     */
    public List<ActionWithoutIndicator> findActionsByMissionNotInId(int idMission) {
        ProjectionFactory pf = new SpelAwareProxyProjectionFactory();
        List<Integer> idActions = this.findActionsByMissionId(idMission)
                .stream()
                .map(ActionWithoutIndicator::getId)
                .toList();
        return this.actionRepository.findByIdNotIn(idActions)
                .stream()
                .map(action -> pf.createProjection(ActionWithoutIndicator.class, action))
                .toList();
    }

    /**
     * Ajoute une action à une mission
     *
     * @param idMission ID de la mission
     * @param idAction  ID de l'action
     */
    public void addActionToMission(int idMission, int idAction) {
        Mission mission = missionRepository.findById(idMission).orElseThrow(NotExistException::new);
        Action action = actionRepository.findById(idAction).orElseThrow(NotExistException::new);
        ActionMissionId actionMissionId = new ActionMissionId();
        actionMissionId.setFkAction(action.getId());
        actionMissionId.setFkMission(mission.getId());
        ActionMission actionMission = new ActionMission();
        actionMission.setId(actionMissionId);
        actionMissionRepository.save(actionMission);
    }
}
