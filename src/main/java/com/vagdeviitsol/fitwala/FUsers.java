package com.vagdeviitsol.fitwala;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class FUsers {
	
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
	@Column(name="FIST_NAME")
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
    
    public String getfistName()
    {
    	return fistName;
    }
    public void setfistName(String fistname)
    {
    	this.fistName=fistname;
    }
    public  String getlateName()
    {
    	return lastName;
    }
    public void setlastName(String lastname)
    {
    	this.lastName=lastname;
    }
    public String getemailID()
    {
    	return emailID;
    }
    public void setemailID(String emailId)
    {
    	this.emailID=emailId;
    }
    public long getmobileNo()
    {
    	return mobileNo;
    }
    public void setmobileNo(long Mobileno)
    {
    	this.mobileNo=Mobileno;
    }
    public String getgender()
    {
    	return gender;
    }
    public void setgender(String gender)
    {
    	this.gender=gender;
    }
    public int getage()
    {
    	return age;
    }
    public void setage(int Age)
    {
    	this.age=Age;
    }
    public String getaddress()
    {
    	return address;
    }
    public void setaddress(String Address)
    {
    	this.address=Address;
    }
	public String getGymName() 
	{
		return gymName;
	}
	public void setGymName(String Gymname) 
	{
		this.gymName = Gymname;
	}
	public int getplanType() 
	{
		return planType;
	}
	public void setplanType(int Plantype) {
		this.planType=Plantype;
	}
	
}

