package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Inscription;
import fr.polytech.projet.projetapi.projection.InscriptionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    List<InscriptionInfo> findByUtilisateur_Id(Integer id);
}