package pe.edu.upc.pandemia.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Locations", 
		indexes = { @Index(columnList = "city", name = "locations_index_city"), 
					@Index(columnList = "state_province", name = "location_index_state_province")})
@SequenceGenerator(name = "Locations_location_id_seq", initialValue = 3300, allocationSize = 100)
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Locations_location_id_seq")
	@Column(name = "location_id", columnDefinition = "NUMERIC(4)")
	private Integer id;
	
	@Column(name = "street_address", length = 40)
	private String streetAddress;
	
	@Column(name = "postal_code", length = 12)
	private String postalCode;
	
	@Column(name = "city", length = 30, nullable = false)
	private String city;
	
	@Column(name = "state_province", length = 25)
	private String stateProvince;
	
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;	// Country_id
	
	@OneToMany(mappedBy = "location")
	private List<Department> departments;
	
	// -- Constructor, Getter y Setter
	public Location() {
		departments = new ArrayList<Department>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
}
