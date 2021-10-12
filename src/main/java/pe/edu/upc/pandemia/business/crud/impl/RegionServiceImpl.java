package pe.edu.upc.pandemia.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.pandemia.business.crud.RegionService;
import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.model.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Override
	public JpaRepository<Region, Integer> getJpaRepository() {
		return regionRepository;
	}

	@Override
	public List<Region> findByName(String name) throws Exception {
		return regionRepository.findByName(name);
	}
	

}
