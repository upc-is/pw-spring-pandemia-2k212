package pe.edu.upc.pandemia.business.crud;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Region;

public interface RegionService extends CrudService<Region, Integer> {
	List<Region> findByName(String name) throws Exception;
}
