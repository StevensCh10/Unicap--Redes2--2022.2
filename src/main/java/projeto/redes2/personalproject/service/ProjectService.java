package projeto.redes2.personalproject.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.redes2.personalproject.model.Project;
import projeto.redes2.personalproject.repository.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	
	@Autowired
	public ProjectService(ProjectRepository projectRepo) {
		this.projectRepository = projectRepo;
	}
	
	public ArrayList<String> allProjects(Long id){
		return projectRepository.allProjects(id);
	}
	
	public Project addProject(Project p, Long idUser) {
		Project project = projectRepository.saveAndFlush(p);
		projectRepository.updateFkUser(idUser, project.getId());
		
		return project;
	}
	
	public Project updateProjectName(String newProjectName, Long id) {
		Project byId = projectRepository.getReferenceById(id);
		byId.setProjectName(newProjectName);
		
		return projectRepository.saveAndFlush(byId);
	}
	
	public Project updateDescription(String newDescription, Long id) {
		Project byId = projectRepository.getReferenceById(id);
		byId.setDescription(newDescription);
		
		return projectRepository.saveAndFlush(byId);
	}
	
	public Project updateSituation(Long id) {
		Project byId = projectRepository.getReferenceById(id);
		byId.setSituation(!byId.getSituation());
		
		return projectRepository.saveAndFlush(byId);
	}
	
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}
}
