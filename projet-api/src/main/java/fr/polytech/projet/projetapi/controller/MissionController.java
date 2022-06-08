package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.projection.InscriptionInfo;
import fr.polytech.projet.projetapi.service.ServiceMission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mission")
public class MissionController {
    private final ServiceMission serviceMission;
    private final Logger logger = LoggerFactory.getLogger(MissionController.class);

    public MissionController(ServiceMission serviceMission) {
        this.serviceMission = serviceMission;
    }

    @GetMapping
    public ResponseEntity<List<Mission>> getAllMissions() {
        logger.info("REST GET getAllMissions");
        return ResponseEntity.ok(this.serviceMission.getAllMissions());
    }

    @GetMapping("{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable int id) {
        logger.info("REST GET getMissionById : {}", id);
        return ResponseEntity.of(this.serviceMission.getMissionById(id));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<InscriptionInfo>> getMissionsByUserId(@PathVariable int idUser) {
        logger.info("REST GET getMissionsByUserId : {}", idUser);
        return ResponseEntity.ok(this.serviceMission.getMissionsByUserId(idUser));
    }

    @GetMapping("/user/noninscrit/{idUser}")
    public ResponseEntity<List<Mission>> getMissionsNonInscritByUserId(@PathVariable int idUser) {
        logger.info("REST GET getMissionsNonInscritByUserId : {}", idUser);
        return ResponseEntity.ok(this.serviceMission.getMissionsNonInscritsByUserId(idUser));
    }

    @GetMapping("inscription/{idUser}/{idMission}")
    public ResponseEntity<Boolean> inscription(@PathVariable int idUser, @PathVariable int idMission) {
        logger.info("REST GET inscription : {}", idUser);
        this.serviceMission.inscription(idUser, idMission);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
