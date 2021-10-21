package pe.edu.upc.pandemia.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Jobs")
public class Job {	// Perfil/Rol/Puesto laboral
	@NotBlank
	@Id
	@Column(name = "job_id", length = 10)
	private String id;
	
	@NotNull
	@NotBlank
	@Size(max = 35)
	@Column(name = "job_title", length = 35, nullable = false)
	private String title;
	
	@Max(value = 999999)
	@Min(value = 1)
	@Column(name = "min_salary", columnDefinition = "NUMERIC(6)")
	private Integer minSalary;
	
	@Max(value = 999999)
	@Min(value = 1)
	@Column(name = "max_salary", columnDefinition = "NUMERIC(6)")
	private Integer maxSalary; 
	
	@OneToMany(mappedBy = "job",  fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private List<JobHistory> jobHistories;
	
	// -- Constructor, Getter y Setter
	public Job() {
		employees = new ArrayList<Employee>();
		jobHistories = new ArrayList<JobHistory>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<JobHistory> getJobHistories() {
		return jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}
	
}
