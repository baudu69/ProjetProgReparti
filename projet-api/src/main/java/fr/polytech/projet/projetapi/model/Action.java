package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "action")
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_action")
	private Action fkAction;

	@Column(name = "wording", length = 25)
	private String wording;

	@Column(name = "scoreMinimum")
	private Integer scoreMinimum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Action getFkAction() {
		return fkAction;
	}

	public void setFkAction(Action fkAction) {
		this.fkAction = fkAction;
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

}