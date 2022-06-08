package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "action__mission")
public class ActionMission {
	@EmbeddedId
	private ActionMissionId id;

	@MapsId("fkAction")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_action", nullable = false)
	private Action fkAction;

	public ActionMissionId getId() {
		return id;
	}

	public void setId(ActionMissionId id) {
		this.id = id;
	}

	public Action getFkAction() {
		return fkAction;
	}

	public void setFkAction(Action fkAction) {
		this.fkAction = fkAction;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"EmbeddedId = " + id + ")";
	}
}