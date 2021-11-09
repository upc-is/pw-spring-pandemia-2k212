package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.utils.EmployeeSearch;

@Controller
@RequestMapping("/apply")
@SessionAttributes("{employeeSearch}")
public class ApplyController {
	
	@GetMapping
	public String home(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch) {
		model.addAttribute("employeeSearch", employeeSearch);
		return "apply/index";
	}
}
