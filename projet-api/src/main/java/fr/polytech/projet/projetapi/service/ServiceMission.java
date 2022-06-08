package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.projection.InscriptionInfo;
import fr.polytech.projet.projetapi.repository.InscriptionRepository;
import fr.polytech.projet.projetapi.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMission {
    private final MissionRepository missionRepository;
    private final InscriptionRepository inscriptionRepository;

    public ServiceMission(MissionRepository missionRepository, ServiceApprenant serviceApprenant, InscriptionRepository inscriptionRepository) {
        this.missionRepository = missionRepository;
        this.inscriptionRepository = inscriptionRepository;
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
}
