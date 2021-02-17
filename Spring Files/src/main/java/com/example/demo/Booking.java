package com.example.demo;

public class Booking {
	
	private int bookingId;
	public String email;
	public String contactNumber;
	public String residentialAddress;
	public String dateofTravel;
	public int numberofAdults;
	public int numberofChildren;
	public String bookingStatus;
	
	public Booking() {}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int BookingId) {
		bookingId = BookingId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		email = Email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String ContactNumber) {
		contactNumber = ContactNumber;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String ResidentialAddress) {
		residentialAddress = ResidentialAddress;
	}
	public String getDateofTravel() {
		return dateofTravel;
	}
	public void setDateofTravel(String DateofTravel) {
		dateofTravel = DateofTravel;
	}
	public int getNumberofAdults() {
		return numberofAdults;
	}
	public void setNumberofAdults(int NumberofAdults) {
		numberofAdults = NumberofAdults;
	}
	public int getNumberofChildren() {
		return numberofChildren;
	}
	public void setNumberofChildren(int NumberofChildren) {
		numberofChildren = NumberofChildren;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String BookingStatus) {
		bookingStatus = BookingStatus;
	}
	
	public Booking(int bid,String email,String contact,String Residential,String DOT,int nAdults,int nChildren,String Bstatus)
	{
		this.bookingId=bid;
		this.email=email;
		this.contactNumber=contact;
		this.residentialAddress=Residential;
		this.dateofTravel=DOT;
		this.numberofAdults=nAdults;
		this.numberofChildren=nChildren;
		this.bookingStatus=Bstatus;
		
	}
	
	
	

}
