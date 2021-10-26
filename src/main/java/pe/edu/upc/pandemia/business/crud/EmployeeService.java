package pe.edu.upc.pandemia.business.crud;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Employee;

public interface EmployeeService extends CrudService<Employee, Integer> {
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
	List<Employee> findByLastName(String lastName) throws Exception;
}
