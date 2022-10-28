package projeto.redes2.personalproject.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.redes2.personalproject.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Query(
		value = "SELECT DISTINCT project_name FROM project WHERE fk_user = :id",
		nativeQuery = true
	)
	public ArrayList<String> allProjects(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(
		value = "UPDATE project SET fk_user = :idUser WHERE id = :idProject",
		nativeQuery = true
	)
	public void updateFkUser(@Param("idUser") Long idUser,@Param("idProject") Long idProject);

}
