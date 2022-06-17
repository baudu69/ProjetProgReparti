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

	public ObjectifActionId getId() {
		return id;
	}

	public void setId(ObjectifActionId id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
