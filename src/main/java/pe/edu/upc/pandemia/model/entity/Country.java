package pe.edu.upc.pandemia.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@Table(name = "Countries")
public class Country {
	@NotBlank(message = "El Id debe contener datos")
	@Size(max = 2, message = "El tamano máximo del Id debe ser 2")
	@Id 
	@Column(name = "country_id", length = 2, nullable = false)
	private String id;
	
	@NotNull(message = "El name debe contener valor")
	@NotBlank(message = "El name debe contener datos")
	@Size(max = 40, message = "El tamano máximo del name debe ser 40")
	@Column(name = "country_name", length = 40)
	private String name;
	
	@JsonIgnoreProperties("contries")
	@NotNull
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)	// Foreing Key
	private Region region; // Region_Id
	
	@JsonIgnore
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Location> locations;
	
	// -- Constructor, Getter y Setter
	public Country() {
		locations = new ArrayList<Location>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
}
