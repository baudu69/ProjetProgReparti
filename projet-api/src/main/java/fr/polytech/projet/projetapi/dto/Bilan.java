package fr.polytech.projet.projetapi.dto;

import fr.polytech.projet.projetapi.projection.UtilisateurInfo;

import java.io.Serializable;
import java.util.List;

public record Bilan(UtilisateurInfo apprenant, List<MissionBilan> missionBilans) implements Serializable {
}
