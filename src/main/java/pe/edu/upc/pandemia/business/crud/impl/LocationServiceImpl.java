package pe.edu.upc.pandemia.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.business.crud.LocationService;
import pe.edu.upc.pandemia.model.entity.Location;
import pe.edu.upc.pandemia.model.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository; 
	
	@Override
	public JpaRepository<Location, Integer> getJpaRepository() {
		return locationRepository;
	}

	@Override
	public List<Location> findByCity(String city) throws Exception {
		return locationRepository.findByCity(city);
	}

	@Override
	public List<Location> findByStateProvince(String stateProvince) throws Exception {
		return locationRepository.findByStateProvince(stateProvince);
	}
}
