package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NumUtil", nullable = false)
	private Integer id;

	@Column(name = "NomUtil", nullable = false, length = 100)
	private String nomUtil;

	@Column(name = "MotPasse", nullable = false, length = 100)
	private String motPasse;

	@Column(name = "salt", nullable = false, length = 100)
	private String salt;

	@Column(name = "role", nullable = false, length = 100)
	private String role;

	@Column(name = "surname", length = 50)
	private String surname;

	@Column(name = "forename", length = 50)
	private String forename;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomUtil() {
		return nomUtil;
	}

	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"nomUtil = " + nomUtil + ", " +
				"motPasse = " + motPasse + ", " +
				"salt = " + salt + ", " +
				"role = " + role + ", " +
				"surname = " + surname + ", " +
				"forename = " + forename + ")";
	}
}