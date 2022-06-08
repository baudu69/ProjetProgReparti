package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Indicator;
import fr.polytech.projet.projetapi.service.ServiceAction;
import fr.polytech.projet.projetapi.service.ServiceIndicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
