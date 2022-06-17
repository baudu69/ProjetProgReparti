package fr.polytech.projet.projetapi.dto;

import fr.polytech.projet.projetapi.model.Mission;

import java.io.Serializable;
import java.util.List;

public record MissionBilan(Mission mission, List<ActionBilan> actionBilans, boolean completed) implements Serializable {
}
