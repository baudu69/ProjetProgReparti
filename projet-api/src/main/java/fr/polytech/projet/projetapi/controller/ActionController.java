package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.service.ServiceAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/action")
public class ActionController {
    private final ServiceAction serviceAction;
    private final Logger logger = LoggerFactory.getLogger(ActionController.class);

    public ActionController(ServiceAction serviceAction) {
        this.serviceAction = serviceAction;
    }

    /**
     * @return List of all actions
     */
    @GetMapping
    public ResponseEntity<List<Action>> findAllActions() {
        logger.info("REST GET findAllActions");
        return ResponseEntity.ok(this.serviceAction.findAll());
    }
}
