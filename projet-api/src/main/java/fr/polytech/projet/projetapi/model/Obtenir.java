package fr.polytech.projet.projetapi.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Obtenir {

	@EmbeddedId
	private ObtenirId id;

	private LocalDate dateObtention;

	public ObtenirId getId() {
		return id;
	}

	public void setId(ObtenirId id) {
		this.id = id;
	}

	public LocalDate getDateObtention() {
		return dateObtention;
	}

	public void setDateObtention(LocalDate dateObtention) {
		this.dateObtention = dateObtention;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Obtenir obtenir = (Obtenir) o;
		return Objects.equals(id, obtenir.id) && Objects.equals(dateObtention, obtenir.dateObtention);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, dateObtention);
	}

	@Override
	public String toString() {
		return "Obtenir{" +
				"id=" + id +
				", dateObtention=" + dateObtention +
				'}';
	}
}
