package fr.polytech.projet.projetapi.repository;

import fr.polytech.projet.projetapi.model.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorRepository extends JpaRepository<Indicator, Integer> {
}