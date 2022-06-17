package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Jeu;
import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.service.ServiceJeu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jeu")
public class JeuController {
    private final ServiceJeu serviceJeu;
    private final Logger logger = LoggerFactory.getLogger(JeuController.class);

    public JeuController(ServiceJeu serviceJeu) {
        this.serviceJeu = serviceJeu;
    }

    /**
     * @return List of all jeux
     */
    @GetMapping
    public ResponseEntity<List<Jeu>> findAllActions() {
        logger.info("REST GET findAllJeux");
        return ResponseEntity.ok(this.serviceJeu.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jeu> findActionById(@PathVariable("id") Integer id) {
        logger.info("REST GET findJeuById");
        return ResponseEntity.of(this.serviceJeu.findById(id));
    }

    @GetMapping("/mission/{id}")
    public ResponseEntity<List<Mission>> findAllMissionOfAJeu(@PathVariable("id") Integer id) {
        logger.info("REST GET findAllMissionOfAJeu");
        return ResponseEntity.ok(this.serviceJeu.findMissionsByJeuId(id));
    }

    @GetMapping("/{idJeu}/inscription/{idUser}")
    public ResponseEntity<?> inscriptionApprenantToAJeu(@PathVariable int idUser, @PathVariable int idJeu) {
        logger.info("REST GET inscriptionApprenantToAJeu : User : {},  Jeu{}", idUser, idJeu);
        this.serviceJeu.inscriptionApprenantToAJeu(idJeu, idUser);
        return ResponseEntity.noContent().build();
    }
}
