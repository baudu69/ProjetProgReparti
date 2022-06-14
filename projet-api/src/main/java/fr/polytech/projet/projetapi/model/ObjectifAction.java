package fr.polytech.projet.projetapi.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ObjectifAction {

	@EmbeddedId
	private ObjectifActionId id;

	@Column(nullable = false)
	private String libelle;
}
