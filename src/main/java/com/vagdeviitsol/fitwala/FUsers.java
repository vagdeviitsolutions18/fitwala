package com.vagdeviitsol.fitwala;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class FUsers {
	
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public int getPlanType() {
		return planType;
	}
	public void setPlanType(int planType) {
		this.planType = planType;
	}
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="FISTNAME")
	private String fistName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAILID")
	private String emailID;
	
	@Column(name="MOBILENUMBER")
	private long mobileNo;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="GYMNAME")
	private String gymName;
	
	@Column(name="PLANTYPE")
    private int planType;
    
    
	
}

