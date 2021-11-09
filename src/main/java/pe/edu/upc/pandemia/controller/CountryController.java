package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pandemia.business.crud.CountryService;
import pe.edu.upc.pandemia.business.crud.RegionService;
import pe.edu.upc.pandemia.model.entity.Country;
import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.utils.EmployeeSearch;

@Controller
@RequestMapping("/countries")
@SessionAttributes("{employeeSearch, country}")
public class CountryController {

	@Autowired
	private CountryService countryService; 
	
	@Autowired
	private RegionService regionService;
	
	@GetMapping
	public String list(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch) {
		try {
			List<Country> countries = countryService.getAll();
			model.addAttribute("countries", countries);
			model.addAttribute("employeeSearch", employeeSearch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "countries/list";
	}
	
	@GetMapping("new")
	public String newCountry(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch) {
		try {
			List<Region> regions = regionService.getAll();
			model.addAttribute("regions", regions);
			model.addAttribute("country", new Country());	
			model.addAttribute("employeeSearch", employeeSearch);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "countries/new";
	}
	
	@PostMapping("saveNew")
	public String saveNew(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch, @Valid @ModelAttribute("country") Country country, 
			BindingResult result) {
		if(result.hasErrors()) {
			
		}

		try {
			Country countrySaved = countryService.create(country);		
			model.addAttribute("country", countrySaved);
			model.addAttribute("employeeSearch", employeeSearch);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "countries/view";
	}
	
	@GetMapping("{id}/edit")
	public String edit(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch, @PathVariable("id") String id) {
		try {
			if(countryService.existsById(id)) {
				Optional<Country> optional = countryService.findById(id);
				List<Region> regions = regionService.getAll();
				model.addAttribute("country", optional.get());
				model.addAttribute("regions", regions);
				model.addAttribute("employeeSearch", employeeSearch);
			} else {
				return "redirect:/countries";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "countries/edit";
	}
	
	@PostMapping("saveedit")
	public String saveEdit(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch, @ModelAttribute("country") Country country ) {
		try {				
			Country countrySaved = countryService.update(country);		
			model.addAttribute("country", countrySaved);
			model.addAttribute("employeeSearch", employeeSearch);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "countries/view";
	}
	
	@GetMapping("{id}/del")
	public String delete(Model model, @ModelAttribute("employeeSearch") EmployeeSearch employeeSearch, @PathVariable("id") String id) {
		try {
			if(countryService.existsById(id)) {
				countryService.deleteById(id);
			} else {
				return "redirect:/countries";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/countries";
	}
	
	
	
	
	
	
	
	
}
