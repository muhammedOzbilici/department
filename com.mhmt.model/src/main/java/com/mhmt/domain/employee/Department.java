package com.mhmt.domain.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
		@NamedQuery(name = "Deparment.findAll" , query = "SELECT d FROM Department d "),
		@NamedQuery(name = "Deparment.findByDepartmentName" , query = "SELECT d.departmentName FROM Department d "),
		@NamedQuery(name = "Deparment.findLocationAndEmployeesByDepartmentId" , query = "SELECT d FROM Department d "
				+ " LEFT OUTER JOIN FETCH d.location LEFT OUTER JOIN d.employees WHERE d.deparmtentId = :departmentId")
})

public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private  Long departmentId;
	
	@Column
	private String  departmentName;
	
	@ManyToOne(targetEntity = Location.class , fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id" , foreignKey = @ForeignKey(foreignKeyDefinition = "location_fk"))
	private Location location;
	// FetchType , eager oldu�unda, select department sorgusunda, location tablosuna
	// gider ordan da bilgi �eker, lazy dedi�inde gitmez, performans i�in iyidir. 
	// lazy olursa, department.getLocation dersen , getirmez hibernate.
	// FetchType tan�mlanmaz ise, hibernate default olarak serverConnection a��k
	// iken location getirir, kapand���nda detached error verir getirmez.
	// targetEntity = Location.class hangi location nerden geldi
	// @ManyToOne birden fazla departman, bir location'a
	
	
	@OneToMany(cascade =  CascadeType.ALL , mappedBy = "department")
	private List<Employee> employees;
	
	public Department() {
	}

	public Department(String departmentName, Location location, List<Employee> employees) {
		this.departmentName = departmentName;
		this.location = location;
		this.employees = employees;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
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
		Department other = (Department) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		return true;
	}
	

}
