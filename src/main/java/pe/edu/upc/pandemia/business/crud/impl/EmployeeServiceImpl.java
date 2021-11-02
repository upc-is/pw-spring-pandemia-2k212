package pe.edu.upc.pandemia.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.business.crud.EmployeeService;
import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public JpaRepository<Employee, Integer> getJpaRepository() {
		return employeeRepository;
	}

	@Override
	public List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return employeeRepository.findByLastNameAndFirstName(lastName, firstName);
	}

	@Override
	public List<Employee> findByLastName(String lastName) throws Exception {
		return employeeRepository.findByLastName(lastName);
	}

	@Override
	public List<Employee> findByLastNameContaining(String lastName) throws Exception {
		return employeeRepository.findByLastNameContaining(lastName);
	}
	
	
}
