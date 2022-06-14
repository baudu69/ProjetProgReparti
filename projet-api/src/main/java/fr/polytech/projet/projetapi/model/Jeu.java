package fr.polytech.projet.projetapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jeu")
public class Jeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Jeu jeu = (Jeu) o;
		return Objects.equals(id, jeu.id) && Objects.equals(libelle, jeu.libelle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, libelle);
	}

	@Override
	public String toString() {
		return "Jeu{" +
				"id=" + id +
				", libelle='" + libelle + '\'' +
				'}';
	}
}