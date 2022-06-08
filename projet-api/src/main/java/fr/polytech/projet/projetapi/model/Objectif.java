package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "objectif")
public class Objectif {
    @Id
    @Column(name = "num_objectif", nullable = false)
    private Integer id;

    @Column(name = "lib_objectif")
    private Character libObjectif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mission")
    private Mission idMission;

    public Mission getIdMission() {
        return idMission;
    }

    public void setIdMission(Mission idMission) {
        this.idMission = idMission;
    }

    public Character getLibObjectif() {
        return libObjectif;
    }

    public void setLibObjectif(Character libObjectif) {
        this.libObjectif = libObjectif;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "libObjectif = " + libObjectif + ")";
    }
}