package pe.edu.upc.pandemia.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private Integer id;
	
	@Column(name = "region_name", length = 25)
	private String name;
	
	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
	private List<Country> contries;
	
	// -- Constructor, Getter y Setter
	public Region() {
		contries = new ArrayList<Country>();
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

	public List<Country> getContries() {
		return contries;
	}

	public void setContries(List<Country> contries) {
		this.contries = contries;
	}
	
}
