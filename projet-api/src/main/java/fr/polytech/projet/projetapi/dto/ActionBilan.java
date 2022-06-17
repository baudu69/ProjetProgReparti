package fr.polytech.projet.projetapi.dto;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Obtenir;

import java.io.Serializable;

public record ActionBilan(Action action, Obtenir obtenir) implements Serializable {
	public boolean isCompleted() {
		if (obtenir == null) return false;
		if (action == null) return false;
		return obtenir.getValeurDebut() >= action.getScoreMinimum();
	}
}
