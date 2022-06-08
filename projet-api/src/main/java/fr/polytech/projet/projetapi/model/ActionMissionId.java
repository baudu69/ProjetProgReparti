package fr.polytech.projet.projetapi.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActionMissionId implements Serializable {
	private static final long serialVersionUID = -1023724478820663735L;
	@Column(name = "fk_action", nullable = false)
	private Integer fkAction;

	@Column(name = "fk_mission", nullable = false)
	private Integer fkMission;

	public Integer getFkAction() {
		return fkAction;
	}

	public void setFkAction(Integer fkAction) {
		this.fkAction = fkAction;
	}

	public Integer getFkMission() {
		return fkMission;
	}

	public void setFkMission(Integer fkMission) {
		this.fkMission = fkMission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ActionMissionId entity = (ActionMissionId) o;
		return Objects.equals(this.fkAction, entity.fkAction) &&
				Objects.equals(this.fkMission, entity.fkMission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fkAction, fkMission);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"serialVersionUID = " + serialVersionUID + ", " +
				"fkAction = " + fkAction + ", " +
				"fkMission = " + fkMission + ")";
	}
}