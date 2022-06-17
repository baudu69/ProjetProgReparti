package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Utilisateur;
import fr.polytech.projet.projetapi.projection.UtilisateurInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	List<UtilisateurInfo> findByRole(String role);

	Optional<UtilisateurInfo> findByIdAndRole(Integer id, String role);

	List<UtilisateurInfo> findDistinctBySurnameOrForename(String surname, String forename);

}