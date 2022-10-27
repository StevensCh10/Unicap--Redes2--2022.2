package projeto.redes2.personalproject.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.redes2.personalproject.model.Activitie;
import projeto.redes2.personalproject.model.Project;
import projeto.redes2.personalproject.model.User;
import projeto.redes2.personalproject.service.ActivitieService;
import projeto.redes2.personalproject.service.ProjectService;
import projeto.redes2.personalproject.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/User")
public class UserResource {
	
	private final UserService userService;
	private final ProjectService projectService;
	private final ActivitieService activiteService;

	
	public UserResource(UserService userService, ProjectService projectService, ActivitieService activiteService) {
		this.userService = userService;
		this.projectService = projectService;
		this.activiteService = activiteService;
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<ArrayList<String>> allProjects(@PathVariable Long id){
		ArrayList<String> projects = projectService.allProjects(id);
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
	@GetMapping("/activities/{id}")
	public ResponseEntity<ArrayList<String>> allActivities(@PathVariable Long id){
		ArrayList<String> a = activiteService.allActivities(id);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@PostMapping("/addProject/{idUser}")
	public ResponseEntity<Project> addProject(@RequestBody Project p,@PathVariable Long idUser){
		Project project = projectService.addProject(p, idUser);
		return new ResponseEntity<>(project, HttpStatus.CREATED);
	}
	
	@PostMapping("/addActivitie/{idProject}")
	public ResponseEntity<Activitie> addActivitie(@RequestBody Activitie a,@PathVariable Long idProject){
		Activitie activitie = activiteService.addActivitie(a, idProject);
		return new ResponseEntity<>(activitie, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUserName/{newUserName}/{id}")
	public ResponseEntity<User> updateUserName(@PathVariable String newUserName, @PathVariable Long id){
		User u = userService.updateUserName(newUserName, id);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@PutMapping("/updatePassword/{newPassword}/{id}")
	public ResponseEntity<User> updatePassword(@PathVariable String newPassword, @PathVariable Long id){
		User u = userService.updatePassword(newPassword, id);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProject/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable Long id){
		projectService.deleteProject(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteActivitie/{id}")
	public void deleteActivitie(@PathVariable Long id){
		activiteService.deleteActivitie(id);
	}
}
