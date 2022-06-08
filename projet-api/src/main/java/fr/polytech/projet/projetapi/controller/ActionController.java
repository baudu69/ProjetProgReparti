package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Indicator;
import fr.polytech.projet.projetapi.service.ServiceAction;
import fr.polytech.projet.projetapi.service.ServiceIndicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/action")
public class ActionController {
    private final ServiceAction serviceAction;
    private final ServiceIndicator serviceIndicator;
    private final Logger logger = LoggerFactory.getLogger(ActionController.class);

    public ActionController(ServiceAction serviceAction, ServiceIndicator serviceIndicator) {
        this.serviceAction = serviceAction;
        this.serviceIndicator = serviceIndicator;
    }

    /**
     * @return List of all actions
     */
    @GetMapping
    public ResponseEntity<List<Action>> findAllActions() {
        logger.info("REST GET findAllActions");
        return ResponseEntity.ok(this.serviceAction.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> findActionById(@PathVariable("id") Integer id) {
        logger.info("REST GET findActionById");
        return ResponseEntity.of(this.serviceAction.findById(id));
    }

    @GetMapping("/indicator/{idAction}")
    public ResponseEntity<List<Indicator>> findAllIndicatorOfAnAction(@PathVariable int idAction) {
        logger.info("REST GET findAllIndicatorOfAnAction : {}", idAction);
        return ResponseEntity.ok(this.serviceIndicator.getAllIndicatorsOfAnAction(idAction));
    }

    @PutMapping("/indicator")
    public ResponseEntity<Boolean> addIndicatorToAnAction(@RequestBody Indicator indicator) {
        logger.info("REST PUT addIndicatorToAnAction : {}", indicator);
        this.serviceIndicator.addIndicatorToAnAction(indicator);
        return ResponseEntity.created(URI.create("")).build();
    }

    @PutMapping
    public ResponseEntity<Boolean> addAction(@RequestBody Action action) {
        logger.info("REST PUT addAction : {}", action);
        this.serviceAction.ajouterAction(action);
        return ResponseEntity.created(URI.create("")).build();
    }
}
