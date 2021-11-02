package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
	List<Employee> findByLastName(String lastName);
	List<Employee> findByLastNameContaining(String lastName);
}
