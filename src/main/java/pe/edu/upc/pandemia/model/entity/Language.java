package pe.edu.upc.pandemia.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "languages")
@SequenceGenerator( name = "Languages_language_id_seq", initialValue = 1, allocationSize = 1 )
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Languages_language_id_seq")
	@Column(name = "language_id", columnDefinition = "NUMERIC(2)")
	private Integer id;
	
	@NotNull
	@NotBlank
	@Size(max = 20)
	@Column(name = "language_name", length = 20, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "languages", fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	// -- Constructor, Getter y Setter
	public Language() {
		employees = new ArrayList<Employee>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
