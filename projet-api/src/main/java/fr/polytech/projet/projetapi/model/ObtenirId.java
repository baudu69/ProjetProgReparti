package fr.polytech.projet.projetapi.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ObtenirId implements Serializable {

	private static final long serialVersionUID = -2208595765642014355L;
	private Integer idApprenant;
	private Integer idAction;

	public Integer getIdApprenant() {
		return idApprenant;
	}

	public void setIdApprenant(Integer idApprenant) {
		this.idApprenant = idApprenant;
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
		ObtenirId obtenirId = (ObtenirId) o;
		return Objects.equals(idApprenant, obtenirId.idApprenant) && Objects.equals(idAction, obtenirId.idAction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idApprenant, idAction);
	}

	@Override
	public String toString() {
		return "ObtenirId{" +
				"idApprenant=" + idApprenant +
				", idAction=" + idAction +
				'}';
	}
}
