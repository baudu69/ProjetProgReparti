package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
	List<Inscription> findByUtilisateur_Id(Integer id);

	List<Inscription> findByUtilisateur_IdAndJeu_Id(Integer id, Integer id1);
}