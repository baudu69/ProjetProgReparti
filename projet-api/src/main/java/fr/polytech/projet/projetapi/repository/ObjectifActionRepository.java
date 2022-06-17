package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.ObjectifAction;
import fr.polytech.projet.projetapi.model.ObjectifActionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ObjectifActionRepository extends JpaRepository<ObjectifAction, ObjectifActionId> {
	List<ObjectifAction> findById_IdObjectif(Integer idObjectif);

	List<ObjectifAction> findById_IdObjectifIn(Collection<Integer> idObjectifs);

}