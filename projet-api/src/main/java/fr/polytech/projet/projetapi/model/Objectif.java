package fr.polytech.projet.projetapi.model;

import javax.persistence.*;

@Entity
@Table(name = "objectif")
public class Objectif {
    @Id
    @Column(name = "num_objectif", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lib_objectif")
    private String libObjectif;

    @JoinColumn(name = "id_mission")
    private Integer idMission;

    public Integer getIdMission() {
        return idMission;
    }

    public void setIdMission(Integer idMission) {
        this.idMission = idMission;
    }

    public String getLibObjectif() {
        return libObjectif;
    }

    public void setLibObjectif(String libObjectif) {
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