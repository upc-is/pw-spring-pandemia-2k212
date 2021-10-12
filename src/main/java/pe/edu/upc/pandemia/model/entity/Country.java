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

@Entity 
@Table(name = "Countries")
public class Country {
	@Id 
	@Column(name = "country_id", length = 2, nullable = false)
	private String id;
	
	@Column(name = "country_name", length = 40)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)	// Foreing Key
	private Region region; // Region_Id
	
	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Location> locations;
	
	@Transient
	private int dato;
	
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
