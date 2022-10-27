package projeto.redes2.personalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projeto.redes2.personalproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(
			value = "SELECT U FROM user as U WHERE U.user_name = ?1 AND U.password = ?2",
			nativeQuery = true
	)
	public User checkLogin(String user_name, String password);
}
