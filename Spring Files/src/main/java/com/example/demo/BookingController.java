package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bs;
	//========================== ALL CRUD OPERATIONS======================================
	
	@RequestMapping(value="/")
	public List<Booking> getBook()
	{
		return bs.getBookings();
	}
	
	//http://localhost:8080/Bookingbyid?id=4
	@RequestMapping(value="/Bookingbyid")
	public List<Booking> getBookById(@RequestParam("id") int id)
	{
		return bs.getBookingById(id);
	}
	
	
	//http://localhost:8080/AddBooking?Email=a@gmail.com&ContactNumber=8808236021&ResidentialAddress=Maharastra ,Pune&DateofTravel=2021-02-11&NumberofAdults=3&NumberofChildren=0
//	@RequestMapping(value="/AddBooking")
//	public int AddBooking(RequestEntity<Booking> b)
//	{
//		
//		return bs.AddBooking(b.getBody().Email,b.getBody().ContactNumber,b.getBody().ResidentialAddress,b.getBody().DateofTravel,b.getBody().NumberofAdults,b.getBody().NumberofChildren).get(0).getResult();
//	}
	@RequestMapping(value="/AddBooking")
	public int AddBooking(@RequestParam("Email") String Email,@RequestParam("ContactNumber") String ContactNumber,@RequestParam("ResidentialAddress") String ResidentialAddress,@RequestParam("DateofTravel") String DateofTravel,@RequestParam("NumberofAdults") int NumberofAdults,@RequestParam("NumberofChildren") int NumberofChildren)
	{
		
		return bs.AddBooking(Email,ContactNumber,ResidentialAddress,DateofTravel,NumberofAdults,NumberofChildren).get(0).getResult();
	}
	
	
	//http://localhost:8080/UpdateStatus?id=4
	@RequestMapping(value="/UpdateStatus")
	public int Updatestaus(@RequestParam("id") int id)
	{
		return bs.UpdateBookingById(id).get(0).getResult();
	}
	
	
	//http://localhost:8080/DeleteBooking?id=4
	@RequestMapping(value="/DeleteBooking")
	public int DeleteBooking(@RequestParam("id") int id)
	{
		return bs.DeleteBookingById(id).get(0).getResult();
	}
}
