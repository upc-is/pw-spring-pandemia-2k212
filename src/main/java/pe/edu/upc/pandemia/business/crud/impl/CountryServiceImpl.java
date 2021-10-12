package pe.edu.upc.pandemia.business.crud.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.business.crud.CountryService;
import pe.edu.upc.pandemia.model.entity.Country;
import pe.edu.upc.pandemia.model.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public JpaRepository<Country, String> getJpaRepository() {
		return countryRepository;
	}

}
