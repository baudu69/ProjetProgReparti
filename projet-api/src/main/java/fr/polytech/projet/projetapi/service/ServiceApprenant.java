package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.dto.ActionBilan;
import fr.polytech.projet.projetapi.dto.Bilan;
import fr.polytech.projet.projetapi.dto.MissionBilan;
import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.*;
import fr.polytech.projet.projetapi.projection.UtilisateurInfo;
import fr.polytech.projet.projetapi.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceApprenant {
	private final UtilisateurRepository utilisateurRepository;
	private final ActionRepository actionRepository;
	private final ObtenirRepository obtenirRepository;
	private final JeuRepository jeuRepository;
	private final InscriptionRepository inscriptionRepository;
	private final MissionRepository missionRepository;
	private final MissionJeuRepository missionJeuRepository;
	private final ObjectifActionRepository objectifActionRepository;
	private final String NOM_ROLE = "learner";

	public ServiceApprenant(UtilisateurRepository utilisateurRepository, ActionRepository actionRepository, ObtenirRepository obtenirRepository, JeuRepository jeuRepository, InscriptionRepository inscriptionRepository, MissionRepository missionRepository, MissionJeuRepository missionJeuRepository, ObjectifActionRepository objectifActionRepository) {
		this.utilisateurRepository = utilisateurRepository;
		this.actionRepository = actionRepository;
		this.obtenirRepository = obtenirRepository;
		this.jeuRepository = jeuRepository;
		this.inscriptionRepository = inscriptionRepository;
		this.missionRepository = missionRepository;
		this.missionJeuRepository = missionJeuRepository;
		this.objectifActionRepository = objectifActionRepository;
	}

	public List<UtilisateurInfo> getAll() {
		return this.utilisateurRepository.findByRole(NOM_ROLE);
	}

	public Optional<UtilisateurInfo> getInfoById(int id) {
		return this.utilisateurRepository.findByIdAndRole(id, NOM_ROLE);
	}

	public int getLastID() {
		return this.utilisateurRepository.findByOrderByIdDesc().stream().map(Utilisateur::getId).findFirst().orElse(1);
	}

	public void addApprenant(Utilisateur utilisateur) {
		utilisateur.setRole(NOM_ROLE);
		utilisateur.setId(null);
		utilisateur.setSalt("LOL");
		Utilisateur utilisateur1 = new Utilisateur();
		utilisateur1.setRole(utilisateur.getRole());
		utilisateur1.setSalt(utilisateur.getSalt());
		utilisateur1.setNomUtil(utilisateur.getNomUtil());
		utilisateur1.setMotPasse(utilisateur.getMotPasse());
		utilisateur1.setSurname(utilisateur.getSurname());
		utilisateur1.setForename(utilisateur.getForename());
		System.out.println(utilisateur1);
		this.utilisateurRepository.save(utilisateur1);
	}

	public void editApprenant(int idApprenant, String nomUtil, String surname, String forename) {
		Utilisateur utilisateur = this.utilisateurRepository.getById(idApprenant);
		utilisateur.setNomUtil(nomUtil);
		utilisateur.setSurname(surname);
		utilisateur.setForename(forename);
		this.utilisateurRepository.save(utilisateur);
	}

	public void deleteApprenant(int idApprenant) {
		this.utilisateurRepository.delete(this.utilisateurRepository.findById(idApprenant).orElseThrow(NotExistException::new));
	}

	public Optional<Utilisateur> getById(int id) {
		return this.utilisateurRepository.findById(id);
	}

	public List<UtilisateurInfo> getBySearch(String recherche) {
		if (recherche == null || recherche.isEmpty() || recherche.isBlank()) return this.getAll();
		//Traitement dans le back car il ya a un bug dans hibernate qui empèche les requetes like
		return this.getAll()
				.stream()
				.filter(
						utilisateurInfo -> utilisateurInfo.getSurname().toLowerCase().contains(recherche.toLowerCase())
								||
								utilisateurInfo.getForename().toLowerCase().contains(recherche.toLowerCase()))
				.toList();
	}

	/**
	 * Ajoute une action à un apprenant
	 *
	 * @param idApprenant ID de l'apprenant
	 * @param idAction    ID de l'action
	 * @param score       Score obtenu de l'action
	 */
	public void obtenirAction(int idApprenant, int idAction, int score, String retourMoniteur) {
		Utilisateur utilisateur = this.utilisateurRepository.findById(idApprenant).orElseThrow(NotExistException::new);
		Action action = this.actionRepository.findById(idAction).orElseThrow(NotExistException::new);
		ObtenirId obtenirId = new ObtenirId();
		obtenirId.setIdApprenant(utilisateur.getId());
		obtenirId.setIdAction(action.getId());
		Obtenir obtenir = new Obtenir();
		obtenir.setId(obtenirId);
		obtenir.setValeurDebut(score);
		obtenir.setDateObtention(LocalDate.now());
		obtenir.setRetourMoniteur(retourMoniteur);
		this.obtenirRepository.save(obtenir);
	}

	/**
	 * @param idApprenant ID de l'apprenant
	 * @return Bilan de l'apprenant
	 */
	@Transactional
	public Bilan getBilanOfAnUser(int idApprenant) {
		UtilisateurInfo utilisateur = this.utilisateurRepository.findByIdAndRole(idApprenant, NOM_ROLE).orElseThrow(NotExistException::new);
		List<Obtenir> obtenirs = this.obtenirRepository.findById_IdApprenant(utilisateur.getId());
		List<Jeu> jeuxUtilisateurInscrit = this.inscriptionRepository.findByUtilisateur_Id(utilisateur.getId())
				.stream()
				.map(Inscription::getJeu)
				.toList();
		if (jeuxUtilisateurInscrit.isEmpty()) return new Bilan(utilisateur, null);
		return new Bilan(utilisateur, this.missionJeuRepository.findById_IdJeuIn(jeuxUtilisateurInscrit
						.stream()
						.map(Jeu::getId)
						.collect(Collectors.toList()))
				.stream()
				.map(missionJeu -> this.missionRepository.findById(missionJeu.getId().getIdMission()).orElseThrow(NotExistException::new))
				.distinct()
				.map(mission -> {
					List<ActionBilan> actions = this.actionRepository.findByIdIn(mission.getObjectifs()
									.stream()
									.map(Objectif::getId)
									.toList())
							.stream()
							.map(action -> new ActionBilan(action, obtenirs.stream()
									.filter(obt -> Objects.equals(obt.getId().getIdAction(), action.getId()))
									.findFirst()
									.orElse(null)))
							.toList();
					boolean completed = actions.stream()
							.allMatch(ActionBilan::isCompleted);
					return new MissionBilan(mission, actions, completed);
				})
				.toList());
	}


}
