package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "inscription__action")
public class InscriptionAction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_inscription", nullable = false)
	private Inscription fkInscription;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_action", nullable = false)
	private Action fkAction;

	@Column(name = "sort")
	private Integer sort;

	@Column(name = "score")
	private Integer score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Inscription getFkInscription() {
		return fkInscription;
	}

	public void setFkInscription(Inscription fkInscription) {
		this.fkInscription = fkInscription;
	}

	public Action getFkAction() {
		return fkAction;
	}

	public void setFkAction(Action fkAction) {
		this.fkAction = fkAction;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"sort = " + sort + ", " +
				"score = " + score + ")";
	}
}