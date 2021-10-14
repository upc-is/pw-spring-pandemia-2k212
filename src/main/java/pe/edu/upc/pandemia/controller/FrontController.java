package pe.edu.upc.pandemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {

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
