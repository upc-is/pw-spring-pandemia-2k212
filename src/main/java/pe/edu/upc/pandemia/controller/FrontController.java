package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.utils.EmployeeSearch;

@Controller
@RequestMapping("/")
@SessionAttributes("{employeeSearch}")
public class FrontController {

	@GetMapping
	public String home(Model model) {
		EmployeeSearch employeeSearch = new EmployeeSearch();
		model.addAttribute("employeeSearch", employeeSearch);
		return "home";
	}
	
	@GetMapping("inicio")	// request
	public String index() {
		return "ejemplo";
	}
	
	@GetMapping("inicio2")	// request
	public String inicio2() {
		return "ejemplo2";
	}
	
	@GetMapping("inicio2-sub")	// request
	public String inicio3() {
		return "ejemplo2";
	}
	
}
