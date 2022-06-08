package fr.polytech.projet.projetapi.service;

import fr.polytech.projet.projetapi.exception.AlreadyExistException;
import fr.polytech.projet.projetapi.exception.NotExistException;
import fr.polytech.projet.projetapi.model.Utilisateur;
import fr.polytech.projet.projetapi.projection.UtilisateurInfo;
import fr.polytech.projet.projetapi.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceApprenant {
	private final UtilisateurRepository utilisateurRepository;
	private final String NOM_ROLE = "learner";

	public ServiceApprenant(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public List<UtilisateurInfo> getAll() {
		return this.utilisateurRepository.findByRole(NOM_ROLE);
	}

	public Optional<UtilisateurInfo> getById(int id) {
		return this.utilisateurRepository.findByIdAndRole(id, NOM_ROLE);
	}

	public void addApprenant(Utilisateur utilisateur) {
		if (!utilisateur.getRole().equals(NOM_ROLE)) throw new IllegalArgumentException("Le role ne correspond pas");
		if (this.getById(utilisateur.getId()).isPresent()) throw new AlreadyExistException();
		this.utilisateurRepository.save(utilisateur);
	}

	public void deleteApprenant(int idApprenant) {
		this.utilisateurRepository.delete(this.utilisateurRepository.findById(idApprenant).orElseThrow(NotExistException::new));
	}
}
