package fr.polytech.projet.projetapi.projection;

import java.time.LocalDate;

public interface InscriptionjeuInfo {
	Integer getId();

	LocalDate getDate();

	JeuInfo getJeu();

	interface JeuInfo {
		Integer getId();
	}
}
