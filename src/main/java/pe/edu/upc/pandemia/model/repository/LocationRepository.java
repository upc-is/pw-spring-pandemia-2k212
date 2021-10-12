package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	List<Location> findByCity(String city) throws Exception;
	List<Location> findByStateProvince(String stateProvince) throws Exception;
}
