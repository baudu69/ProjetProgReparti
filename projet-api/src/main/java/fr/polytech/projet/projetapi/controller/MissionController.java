package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Mission;
import fr.polytech.projet.projetapi.projection.ActionWithoutIndicator;
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

    /**
     * @param idMission ID de mission
     * @return liste des ActionWithoutIndicator de la mission
     */
    @GetMapping("action/{idMission}")
    public ResponseEntity<List<ActionWithoutIndicator>> getActionsOfMission(@PathVariable int idMission) {
        logger.info("REST GET getActionsOfMission : {}", idMission);
        return ResponseEntity.ok(this.serviceMission.findActionsByMissionId(idMission));
    }

    /**
     * @param idMission ID de mission
     * @return liste des ActionWithoutIndicator qui ne sont pas de la mission
     */
    @GetMapping("action/{idMission}/not")
    public ResponseEntity<List<ActionWithoutIndicator>> getActionsOfMissionNotIn(@PathVariable int idMission) {
        logger.info("REST GET getActionsOfMission : {}", idMission);
        return ResponseEntity.ok(this.serviceMission.findActionsByMissionNotInId(idMission));
    }

    @GetMapping("action/{idMission}/{idAction}")
    public ResponseEntity<Boolean> addActionToMission(@PathVariable int idAction, @PathVariable int idMission) {
        logger.info("REST GET addActionToMission : {}", idAction);
        this.serviceMission.addActionToMission(idMission, idAction);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
