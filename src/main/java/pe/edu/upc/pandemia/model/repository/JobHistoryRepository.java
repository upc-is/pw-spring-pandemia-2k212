package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.entity.JobHistory;
import pe.edu.upc.pandemia.model.entity.JobHistoryId;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
	List<JobHistory> findByEmployee(Employee employee);
}
