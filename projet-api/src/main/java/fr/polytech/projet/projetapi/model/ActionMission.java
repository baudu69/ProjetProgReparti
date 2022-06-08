package fr.polytech.projet.projetapi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "action__mission")
public class ActionMission {
	@EmbeddedId
	private ActionMissionId id;


	public ActionMissionId getId() {
		return id;
	}

	public void setId(ActionMissionId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"EmbeddedId = " + id + ")";
	}
}