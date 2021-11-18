package pe.edu.upc.pandemia.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Country>> list() {
		List<Country> countries = null;
		try {
			countries = countryService.getAll();
		} catch (Exception e) {
			return new ResponseEntity<List<Country>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		ResponseEntity<List<Country>> response = new ResponseEntity<>(countries, HttpStatus.OK );
		return response;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> saveNew(@RequestBody Country country) {
		try {
			Country countrySaved = countryService.create(country);	
			return new ResponseEntity<>(countrySaved, HttpStatus.OK );
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> updateNew(@PathVariable("id") String id, @RequestBody Country country) {
		try {
			if (id.equals(country.getId())) {
				if (countryService.existsById(id)) {
					Country countrySaved = countryService.update(country);
					return new ResponseEntity<>(countrySaved, HttpStatus.OK );
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}		
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		try {
			if (countryService.existsById(id)) {
				countryService.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}		
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	

}
