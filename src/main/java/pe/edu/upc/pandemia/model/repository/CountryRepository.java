package pe.edu.upc.pandemia.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
