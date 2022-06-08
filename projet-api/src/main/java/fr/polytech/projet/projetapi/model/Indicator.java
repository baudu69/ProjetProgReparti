package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "indicator")
public class Indicator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_action", nullable = false)
	private Action fkAction;

	@Column(name = "wording", length = 50)
	private String wording;

	@Column(name = "valueIfCheck")
	private Integer valueIfCheck;

	@Column(name = "valueIfUnCheck")
	private Integer valueIfUnCheck;

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

	public Integer getValueIfCheck() {
		return valueIfCheck;
	}

	public void setValueIfCheck(Integer valueIfCheck) {
		this.valueIfCheck = valueIfCheck;
	}

	public Integer getValueIfUnCheck() {
		return valueIfUnCheck;
	}

	public void setValueIfUnCheck(Integer valueIfUnCheck) {
		this.valueIfUnCheck = valueIfUnCheck;
	}

}