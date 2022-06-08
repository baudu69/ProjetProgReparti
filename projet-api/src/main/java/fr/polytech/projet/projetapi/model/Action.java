package fr.polytech.projet.projetapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "action")
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "fk_action")
	private Integer idActionSuivante;

	@Column(name = "wording", length = 25)
	private String wording;

	@Column(name = "scoreMinimum")
	private Integer scoreMinimum;

	@OneToMany(mappedBy = "idAction")
	private List<Indicator> indicator;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdActionSuivante() {
		return idActionSuivante;
	}

	public void setIdActionSuivante(Integer idActionSuivante) {
		this.idActionSuivante = idActionSuivante;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public Integer getScoreMinimum() {
		return scoreMinimum;
	}

	public void setScoreMinimum(Integer scoreMinimum) {
		this.scoreMinimum = scoreMinimum;
	}

	public List<Indicator> getIndicator() {
		return indicator;
	}

	public void setIndicator(List<Indicator> indicator) {
		this.indicator = indicator;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"idActionSuivante = " + idActionSuivante + ", " +
				"wording = " + wording + ", " +
				"scoreMinimum = " + scoreMinimum + ")";
	}
}