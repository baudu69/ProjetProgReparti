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

	private Integer valeurDebut;

	private Integer valeurFin;

	private String retourMoniteur;

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

	public Integer getValeurDebut() {
		return valeurDebut;
	}

	public void setValeurDebut(Integer valeurDebut) {
		this.valeurDebut = valeurDebut;
	}

	public Integer getValeurFin() {
		return valeurFin;
	}

	public void setValeurFin(Integer valeurFin) {
		this.valeurFin = valeurFin;
	}

	public String getRetourMoniteur() {
		return retourMoniteur;
	}

	public void setRetourMoniteur(String retourMoniteur) {
		this.retourMoniteur = retourMoniteur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Obtenir obtenir = (Obtenir) o;
		return Objects.equals(id, obtenir.id) && Objects.equals(dateObtention, obtenir.dateObtention) && Objects.equals(valeurDebut, obtenir.valeurDebut) && Objects.equals(valeurFin, obtenir.valeurFin) && Objects.equals(retourMoniteur, obtenir.retourMoniteur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, dateObtention, valeurDebut, valeurFin, retourMoniteur);
	}

	@Override
	public String toString() {
		return "Obtenir{" +
				"id=" + id +
				", dateObtention=" + dateObtention +
				", valeurDebut=" + valeurDebut +
				", valeurFin=" + valeurFin +
				", retourMoniteur='" + retourMoniteur + '\'' +
				'}';
	}
}
