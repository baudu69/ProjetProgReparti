package fr.polytech.projet.projetapi.projection;

import java.time.LocalDate;

public interface InscriptionInfo {
    LocalDate getDate();

    MissionInfo getMission();

    interface MissionInfo {
        Integer getId();

        String getWording();
    }
}
