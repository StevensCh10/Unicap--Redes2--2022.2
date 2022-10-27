package projeto.redes2.personalproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.redes2.personalproject.model.Activitie;
import projeto.redes2.personalproject.service.ActivitieService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Activitie")
public class ActivitieResource {
	
	private final ActivitieService activiteService;
	
	public ActivitieResource(ActivitieService activiteService) {
		this.activiteService = activiteService;
	}
	
	@PutMapping("/updateDescription/{newDescription}/{id}")
	public ResponseEntity<Activitie> updateDescription(@PathVariable String newDescription,@PathVariable Long id) {
		Activitie a = activiteService.updateDescription(newDescription, id);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}	
}
