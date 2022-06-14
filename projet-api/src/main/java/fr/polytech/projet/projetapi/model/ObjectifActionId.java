package fr.polytech.projet.projetapi.model;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ObjectifActionId implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Integer idObjectif;
	private Integer idAction;

	public Integer getIdObjectif() {
		return idObjectif;
	}

	public void setIdObjectif(Integer idObjectif) {
		this.idObjectif = idObjectif;
	}

	public Integer getIdAction() {
		return idAction;
	}

	public void setIdAction(Integer idAction) {
		this.idAction = idAction;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ObjectifActionId that = (ObjectifActionId) o;
		return Objects.equals(idObjectif, that.idObjectif) && Objects.equals(idAction, that.idAction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idObjectif, idAction);
	}

	@Override
	public String toString() {
		return "ObjectifActionId{" +
				"idObjectif=" + idObjectif +
				", idAction=" + idAction +
				'}';
	}
}
