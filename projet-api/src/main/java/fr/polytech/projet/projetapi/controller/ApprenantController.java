package fr.polytech.projet.projetapi.controller;

import fr.polytech.projet.projetapi.model.Utilisateur;
import fr.polytech.projet.projetapi.projection.UtilisateurInfo;
import fr.polytech.projet.projetapi.service.ServiceApprenant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/apprenant")
public class ApprenantController {
	private final ServiceApprenant serviceApprenant;
	private final Logger logger = LoggerFactory.getLogger(ApprenantController.class);

	public ApprenantController(ServiceApprenant serviceApprenant) {
		this.serviceApprenant = serviceApprenant;
	}

	@GetMapping
	public ResponseEntity<List<UtilisateurInfo>> getAll() {
		logger.info("REST GET getAll");
		return ResponseEntity.ok(this.serviceApprenant.getAll());
	}

	@GetMapping("{idApprenant}")
	public ResponseEntity<UtilisateurInfo> getById(@PathVariable int idApprenant) {
		logger.info("REST GET getById : {}", idApprenant);
		return ResponseEntity.of(this.serviceApprenant.getInfoById(idApprenant));
	}

	@GetMapping("/search={name}")
	public ResponseEntity<List<UtilisateurInfo>> getBySearch(@PathVariable String name) {
		logger.info("REST GET getBySearch : {}", name);
		return ResponseEntity.ok(this.serviceApprenant.getBySearch(name));
	}

	@PutMapping
	public ResponseEntity<?> addApprenant(@RequestBody Utilisateur utilisateur) {
		logger.info("REST PUT addApprenant : {}", utilisateur);
		this.serviceApprenant.addApprenant(utilisateur);
		return ResponseEntity.created(URI.create("/api/apprenant/" + utilisateur.getId())).build();
	}

	@DeleteMapping("{idApprenant}")
	public ResponseEntity<?> deleteApprenant(@PathVariable int idApprenant) {
		logger.info("REST DELETE deleteApprenant : {}", idApprenant);
		this.serviceApprenant.deleteApprenant(idApprenant);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/score")
	public ResponseEntity<?> obtenirAction(@RequestBody Map<String, String> map) {
		logger.info("REST POST obtenirAction : {}", map);
		this.serviceApprenant.obtenirAction(
				Integer.parseInt(map.get("idApprenant")),
				Integer.parseInt(map.get("idAction")),
				Integer.parseInt(map.get("score")),
				map.get("retourMoniteur"));
		return ResponseEntity.noContent().build();
	}
}
