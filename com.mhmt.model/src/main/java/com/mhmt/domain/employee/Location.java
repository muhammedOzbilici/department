package com.mhmt.domain.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "Location.findAll" , query = " SELECT l FROM Location l"),
	@NamedQuery(name = "Location.findDepartmendById" , query = " SELECT l FROM Location l LEFT OUTER JOIN FETCH l.departments  WHERE l.locationId = :locationId")

	
})
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id" , nullable = false , unique = true)
	private Long locationId;
	
	@Column(length = 25)
	private String streetAddress ;
	
	@Column(name = "postal_code")
	private int postalCode;
	
	// Eðer hiçbir þey girilmezse, hibernate default column oluþturur
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "location")
	private List<Department> departments;
	// ALL demek, bu location silinirse , location'a baðlý tüm departmanlarý sil
	// mappedby ile , Department tablosunda, locationId foreignKey olarak tanýmlanacaktýr
	
	public Location() {
	}

	public Location(String streetAddress, int postalCode, String city) {
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
	}
	
	
	
	
	
	

}
