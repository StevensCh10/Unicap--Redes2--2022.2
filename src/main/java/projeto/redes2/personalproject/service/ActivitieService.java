package projeto.redes2.personalproject.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.redes2.personalproject.model.Activitie;
import projeto.redes2.personalproject.repository.ActivitieRepository;

@Service
public class ActivitieService {
	
	private final ActivitieRepository activitieRepository;
	
	@Autowired
	public ActivitieService(ActivitieRepository activitieRepository) {
		this.activitieRepository = activitieRepository;
	}
	
	public ArrayList<String> allActivities(Long id){
		return activitieRepository.allActivities(id);
	}
	
	public Activitie addActivitie(Activitie a, Long idProject) {
		Activitie activitie = activitieRepository.saveAndFlush(a);
		activitieRepository.updateFkProject(idProject, activitie.getId());
		return activitie;
	}
	
	public Activitie updateDescription(String newDescription, Long id) {
		Activitie byId = activitieRepository.getReferenceById(id);
		byId.setDescriptionActivitie(newDescription);
		
		return activitieRepository.saveAndFlush(byId);
	}
	
	public void deleteActivitie(Long id) {
		activitieRepository.deleteById(id);
	}
}
