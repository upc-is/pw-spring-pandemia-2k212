package pe.edu.upc.pandemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.pandemia.business.crud.CountryService;
import pe.edu.upc.pandemia.model.entity.Country;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService; 
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Country> countries = countryService.getAll();
			model.addAttribute("countries", countries);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "countries/list";
	}
}
