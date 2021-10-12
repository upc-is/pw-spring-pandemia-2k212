package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	List<Region> findByName(String name) throws Exception;
}
