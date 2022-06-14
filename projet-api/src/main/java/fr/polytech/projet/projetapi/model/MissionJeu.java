package fr.polytech.projet.projetapi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class MissionJeu {

	@EmbeddedId
	private MissionJeuId id;

	public MissionJeuId getId() {
		return id;
	}

	public void setId(MissionJeuId id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MissionJeu that = (MissionJeu) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public String toString() {
		return "MissionJeu{" +
				"id=" + id +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
