package pe.edu.upc.pandemia.business.crud;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Location;

public interface LocationService extends CrudService<Location, Integer> {
	List<Location> findByCity(String city) throws Exception;
	List<Location> findByStateProvince(String stateProvince) throws Exception;
}
