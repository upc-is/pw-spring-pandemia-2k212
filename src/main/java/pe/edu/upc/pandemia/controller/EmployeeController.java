package pe.edu.upc.pandemia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.business.crud.EmployeeService;
import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.utils.EmployeeSearch;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("view/{employeeId}")
	public String viewData(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch,
			@PathVariable("employeeId") Integer employeeId) {
		
		try {
			if (employeeService.existsById(employeeId)) {
				Optional<Employee> optional = employeeService.findById(employeeId);
				model.addAttribute("employee", optional.get());				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("employeeSearch", employeeSearch);
		return "employees/view-data";
	}
	
	@GetMapping("upgrade/{employeeId}")
	public String upgrade(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch,
			@PathVariable("employeeId") Integer employeeId) {
		
		try {
			if (employeeService.existsById(employeeId)) {
				Optional<Employee> optional = employeeService.findById(employeeId);
				model.addAttribute("employee", optional.get());				
			} else {
				return "redirect:/";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("employeeSearch", employeeSearch);
		return "employees/upgrade";
	}
}
