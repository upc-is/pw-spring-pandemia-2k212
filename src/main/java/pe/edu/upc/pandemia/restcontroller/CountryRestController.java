package pe.edu.upc.pandemia.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.pandemia.business.crud.CountryService;
import pe.edu.upc.pandemia.model.entity.Country;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryRestController {
	
	@Autowired
	private CountryService countryService; 
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> list () {
		List<Country> countries = null;
		try {
			countries = countryService.getAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		ResponseEntity<List<Country>> response = new ResponseEntity<>(countries, HttpStatus.OK );
		return response;
	}

}
