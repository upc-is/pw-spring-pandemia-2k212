package pe.edu.upc.pandemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequestMapping("/countries")
@SessionAttributes("country")
public class CountryController {

	@Autowired
	private CountryService countryService; 
	
	@Autowired
	private RegionService regionService;
	
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
	
	@GetMapping("new")
	public String newCountry(Model model) {
		try {
			List<Region> regions = regionService.getAll();
			model.addAttribute("regions", regions);
			model.addAttribute("country", new Country());			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "countries/new";
	}
	
	@PostMapping("saveNew")
	public String saveNew(Model model, @ModelAttribute("country") Country country ) {
		System.out.println(country.getId());
		System.out.println(country.getName());
		System.out.println(country.getRegion().getName());
		try {
			Country countrySaved = countryService.create(country);		
			model.addAttribute("country", countrySaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "countries/view";
	}
	
	@GetMapping("{id}/edit")
	public String edit(Model model, @PathVariable("id") String id) {
		try {
			if(countryService.existsById(id)) {
				Optional<Country> optional = countryService.findById(id);
				List<Region> regions = regionService.getAll();
				model.addAttribute("country", optional.get());
				model.addAttribute("regions", regions);
			} else {
				return "redirect:/countries";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "countries/edit";
	}
	
	@PostMapping("saveedit")
	public String saveEdit(Model model, @ModelAttribute("country") Country country ) {
		System.out.println(country.getId());
		System.out.println(country.getName());
		try {
			Country countrySaved = countryService.update(country);		
			model.addAttribute("country", countrySaved);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "countries/view";
	}
	
	@GetMapping("{id}/del")
	public String delete(Model model, @PathVariable("id") String id) {
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
