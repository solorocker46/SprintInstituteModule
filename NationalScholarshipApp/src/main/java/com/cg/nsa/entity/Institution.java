package com.cg.nsa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

/**
 * @author Sushma S
 * Version: 1.0
 * Description: This is the entity class - Institution
 * Created date: 19-04-2021
 */

@Entity
@Table(name="institution10")
@PrimaryKeyJoinColumn(name="userId")  
public class Institution extends User
{
	@Column(name = "code")
	@Range(min = 1, message = "Please enter a valid code")
	private int code;
	
	@NotEmpty(message = "Category cannot be empty")
	@Column(name = "category")
	private String category;	//	Government/Private/Autonomous
	
	@Column(name = "type")
	@NotEmpty(message = "Institution type cannot be empty")
	private String type;		// Medical/Law/Engineering
	
	@Column(name = "name")
	@NotEmpty(message = "Institution name cannot be empty")
	private String name;
	
	@Column(name = "university")
	@NotEmpty(message = "University cannot be empty")
	private String university;		// 	University affiliated with
	
	@Column(name = "address")
	@NotEmpty(message = "Address cannot be empty")
	private String address;
	
	@Column(name = "city")
	@NotEmpty(message = "City cannot be empty")
	private String city;
	
	@Column(name = "state")
	@NotEmpty(message = "State cannot be empty")
	private String state;
	
	@Column(name = "yearOpen")
	@Range(min = 1945, max = 2020, message = "Please enter a valid inaugral year")
	private int yearOpen;
	
	@Column(name = "telephone")
	@Size(min = 10, max = 10, message = "Please enter a valid telephone number")
	private String telephone;
	
	@Column(name = "principal")
	@NotEmpty(message = "Principal name cannot be empty")
	private String principal;
	
	@Column(name = "status")
	private String status;		// Pending/Approved/Rejected
	
	public Institution(String userId, String password, String role, int code, String category, String type, String name,
			String university, String address, String city, String state, int yearOpen, String telephone,
			String principal, String status) {
		super(userId, password, role);
		this.code = code;
		this.category = category;
		this.type = type;
		this.name = name;
		this.university = university;
		this.address = address;
		this.city = city;
		this.state = state;
		this.yearOpen = yearOpen;
		this.telephone = telephone;
		this.principal = principal;
		this.status = status;
	}

	public Institution(String userId, String password, String role) {
		super(userId, password, role);
	}
	
	public Institution() {
		super();
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getYearOpen() {
		return yearOpen;
	}

	public void setYearOpen(int yearOpen) {
		this.yearOpen = yearOpen;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Institution [code=" + code + ", category=" + category + ", type=" + type + ", name=" + name
				+ ", university=" + university + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", yearOpen=" + yearOpen + ", telephone=" + telephone + ", principal=" + principal + ", status="
				+ status + "]";
	}
	
	
}
