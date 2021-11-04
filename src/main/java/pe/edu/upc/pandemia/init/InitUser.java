package pe.edu.upc.pandemia.init;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.User;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;
import pe.edu.upc.pandemia.model.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		
		// SOLO DESBLOQUEAR CUANDO QUIERAN AGREGAR UN NUEVO USUARIO
		
		/*Optional<Employee> optional = employeeRepository.findById(197);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			User user = new User("kfeeney", bcpe.encode("kfeeney"), employee);
			user.addAuthority("ROLE_EMPLOYEE");
			user.addAuthority("ACCESS_APPLY");
			//user.addAuthority("ACCESS_EDIT_NAME");
			userRepository.save(user);
		}
		Optional<Employee> optional2 = employeeRepository.findById(150);
		if (optional2.isPresent()) {
			Employee employee2 = optional2.get();
			User user2 = new User("ptucker", bcpe.encode("ptucker"), employee2);
			user2.addAuthority("ROLE_HUMANRESOURCE");
			user2.addAuthority("ACCESS_UPGRADE");
			user2.addAuthority("ACCESS_EDIT_NAME");
			user2.addAuthority("ACCESS_EDIT_SALARY");
			userRepository.save(user2);
		}*/
		
	}

}
