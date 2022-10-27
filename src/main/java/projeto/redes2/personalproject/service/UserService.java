package projeto.redes2.personalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.redes2.personalproject.model.User;
import projeto.redes2.personalproject.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//User userupdate = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("o id não foi encontrado na base"));

	public User checkLogin(String userName, String password) {
		return userRepository.checkLogin(userName, password);
	}
		
	public User registerUser(User u) {
		return userRepository.save(u);
	}
	
	public User updateUserName(String newUserName, Long id) {
		User byId = userRepository.getReferenceById(id);
		byId.setUserName(newUserName);
		
		return userRepository.saveAndFlush(byId);
	}
	
	public User updatePassword(String password, Long id) {
		User byId = userRepository.getReferenceById(id);
		byId.setPassword(password);
		
		return userRepository.saveAndFlush(byId);
	}
}
