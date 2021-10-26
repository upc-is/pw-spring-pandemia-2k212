package pe.edu.upc.pandemia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.business.crud.EmployeeService;
import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.utils.EmployeeSearch;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("employee")
	public String searchEmployees(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch) {

		List<Employee> employees = new ArrayList<>();
		
		try {
			employees = employeeService.findByLastName(employeeSearch.getLastName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("employeeSearch", employeeSearch);
		model.addAttribute("employees", employees);		
		
		return "searchs/view-employees";
	}
	
}
