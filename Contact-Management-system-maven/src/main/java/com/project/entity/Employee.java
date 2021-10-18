package com.project.entity;

import java.time.LocalDate;

public class Employee {
     private int id;
     private String firstName;
     private String lastName;
     private String address;
     private String emailAddress;
     private String phoneNumber;
     private LocalDate birthDate;
     private LocalDate weddingAnniversary;
	
     
     public Employee() {
		super();
		// TODO Auto-generated constructor stub
	 }


	 public Employee(int id, String firstName, String lastName, String address, String emailAddress, String phoneNumber,
			LocalDate birthDate, LocalDate weddingAnniversary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.weddingAnniversary = weddingAnniversary;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	public LocalDate getWeddingAnniversary() {
		return weddingAnniversary;
	}


	public void setWeddingAnniversary(LocalDate weddingAnniversary) {
		this.weddingAnniversary = weddingAnniversary;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate
				+ ", weddingAnniversary=" + weddingAnniversary + "]";
	}
	 
	
     
     
     
     
}
