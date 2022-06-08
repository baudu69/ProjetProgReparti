package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "indicator")
public class Indicator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "fk_action", nullable = false)
	private Integer idAction;

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

	public Integer getIdAction() {
		return idAction;
	}

	public void setIdAction(Integer idAction) {
		this.idAction = idAction;
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

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"idAction = " + idAction + ", " +
				"wording = " + wording + ", " +
				"valueIfCheck = " + valueIfCheck + ", " +
				"valueIfUnCheck = " + valueIfUnCheck + ")";
	}
}