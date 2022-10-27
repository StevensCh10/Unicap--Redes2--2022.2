package projeto.redes2.personalproject.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.redes2.personalproject.model.Activitie;

@Repository
public interface ActivitieRepository extends JpaRepository<Activitie, Long>{
	
		@Query(
			value = "SELECT DISTINCT description_activitie FROM activitie WHERE fk_project = :id",
			nativeQuery = true
		)
		public ArrayList<String> allActivities(@Param("id") Long id);
		
		@Transactional
		@Modifying
		@Query(
			value = "UPDATE activitie SET fk_project = :idProject WHERE id = :idActivitie",
			nativeQuery = true
		)
		public void attFkProject(@Param("idProject") Long idProject,@Param("idActivitie") Long idActivitie);
}
