package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.AlreadyExistException;
import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Obtenir;
import fr.polytech.projet.projetapi.model.ObtenirId;
import fr.polytech.projet.projetapi.model.Utilisateur;
import fr.polytech.projet.projetapi.projection.UtilisateurInfo;
import fr.polytech.projet.projetapi.repository.ActionRepository;
import fr.polytech.projet.projetapi.repository.ObtenirRepository;
import fr.polytech.projet.projetapi.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceApprenant {
	private final UtilisateurRepository utilisateurRepository;
	private final ActionRepository actionRepository;
	private final ObtenirRepository obtenirRepository;
	private final String NOM_ROLE = "learner";

	public ServiceApprenant(UtilisateurRepository utilisateurRepository, ActionRepository actionRepository, ObtenirRepository obtenirRepository) {
		this.utilisateurRepository = utilisateurRepository;
		this.actionRepository = actionRepository;
		this.obtenirRepository = obtenirRepository;
	}

	public List<UtilisateurInfo> getAll() {
		return this.utilisateurRepository.findByRole(NOM_ROLE);
	}

	public Optional<UtilisateurInfo> getInfoById(int id) {
        return this.utilisateurRepository.findByIdAndRole(id, NOM_ROLE);
    }

    public void addApprenant(Utilisateur utilisateur) {
        if (!utilisateur.getRole().equals(NOM_ROLE)) throw new IllegalArgumentException("Le role ne correspond pas");
        if (this.getInfoById(utilisateur.getId()).isPresent()) throw new AlreadyExistException();
	    this.utilisateurRepository.save(utilisateur);
    }

	public void deleteApprenant(int idApprenant) {
		this.utilisateurRepository.delete(this.utilisateurRepository.findById(idApprenant).orElseThrow(NotExistException::new));
	}

	public Optional<Utilisateur> getById(int id) {
		return this.utilisateurRepository.findById(id);
	}

	public List<UtilisateurInfo> getBySearch(String recherche) {
		HashMap<Integer, UtilisateurInfo> mapUtilisateur = new HashMap<>();
		String[] nameSplit = recherche.split(" ");
		this.utilisateurRepository.findDistinctBySurnameOrForename(nameSplit[0], nameSplit[1] == null ? "" : nameSplit[1])
				.stream()
				.map(utilisateurInfo -> mapUtilisateur.putIfAbsent(utilisateurInfo.getId(), utilisateurInfo));

		this.utilisateurRepository.findDistinctBySurnameOrForename(nameSplit[1] == null ? "" : nameSplit[1], nameSplit[0])
				.stream()
				.map(utilisateurInfo -> mapUtilisateur.putIfAbsent(utilisateurInfo.getId(), utilisateurInfo));

		return mapUtilisateur.values().stream().toList();
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
}
