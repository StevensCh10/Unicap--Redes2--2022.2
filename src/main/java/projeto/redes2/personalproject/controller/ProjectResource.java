package projeto.redes2.personalproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.redes2.personalproject.model.Project;
import projeto.redes2.personalproject.service.ProjectService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Project")
public class ProjectResource {
	
	
	private final ProjectService projectService;
	
	public ProjectResource(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@PutMapping("/updateProjectName/{newProjectName}/{id}")
	public ResponseEntity<Project> updateProjectName(@PathVariable String newProjectName, @PathVariable Long id){
		Project p = projectService.updateProjectName(newProjectName, id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping("/updateDescription/{newDescription}/{id}")
	public ResponseEntity<Project> updateDescription(@PathVariable String newDescription, @PathVariable Long id){
		Project p = projectService.updateDescription(newDescription, id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping("/updateSituation/{id}")
	public ResponseEntity<Project> updateSituation(@PathVariable Long id){
		Project p = projectService.updateSituation(id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}
