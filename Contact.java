package com.assignment;
public class Contact {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	long phoneNo;
	String email;
	public Contact(String fName, String lName, String add, String city, String state, int zip, long pNo, String email) {
		super();
		this.firstName = fName;
		this.lastName = lName;
		this.address = add;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = pNo;
		this.email = email;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return firstName + lastName + address + city + state + zip + phoneNo + email;
	}
}
