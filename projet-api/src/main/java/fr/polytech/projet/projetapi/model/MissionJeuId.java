package fr.polytech.projet.projetapi.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MissionJeuId implements Serializable {

	private static final long serialVersionUID = -6441021017027280129L;
	private Integer idMission;
	private Integer idJeu;

	public Integer getIdMission() {
		return idMission;
	}

	public void setIdMission(Integer idMission) {
		this.idMission = idMission;
	}

	public Integer getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(Integer idJeu) {
		this.idJeu = idJeu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MissionJeuId that = (MissionJeuId) o;
		return Objects.equals(idMission, that.idMission) && Objects.equals(idJeu, that.idJeu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMission, idJeu);
	}

	@Override
	public String toString() {
		return "MissionJeuId{" +
				"idMission=" + idMission +
				", idJeu=" + idJeu +
				'}';
	}
}
