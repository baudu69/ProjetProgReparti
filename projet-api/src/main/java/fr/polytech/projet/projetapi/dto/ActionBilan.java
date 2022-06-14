package fr.polytech.projet.projetapi.dto;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Obtenir;

import java.io.Serializable;

public record ActionBilan(Action action, Obtenir obtenir) implements Serializable {
}
