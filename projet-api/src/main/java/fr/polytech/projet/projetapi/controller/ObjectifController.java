package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Action;
import fr.polytech.projet.projetapi.model.Objectif;
import fr.polytech.projet.projetapi.service.ServiceObjectif;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/objectif/")
public class ObjectifController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ServiceObjectif serviceObjectifs;

	public ObjectifController(ServiceObjectif serviceObjectifs) {
		this.serviceObjectifs = serviceObjectifs;
	}

	@GetMapping
	public ResponseEntity<List<Objectif>> findAll() {
		logger.info("GET findAll");
		return ResponseEntity.ok(serviceObjectifs.findAll());
	}

	@GetMapping("{idObjectif}/action")
	public ResponseEntity<List<Action>> getActionOfAnObjectif(@PathVariable int idObjectif) {
		logger.info("GET getActionOfAnObjectif : {}", idObjectif);
		return ResponseEntity.ok(serviceObjectifs.getActionOfAnObjectif(idObjectif));
	}

	@GetMapping("mission/{idMission}")
	public ResponseEntity<List<Objectif>> getObjectifsOfAMission(@PathVariable int idMission) {
		logger.info("GET getObjectifsOfAMission : {}", idMission);
		return ResponseEntity.ok(serviceObjectifs.getObjectifsOfAMission(idMission));
	}
}
