package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookingService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private List<Booking> booking=new ArrayList<Booking>();
	
	private List<Status> result=new ArrayList<Status>();
	
	//Getting all data
	public List<Booking> getBookings()
	{
		String sql="Select * from Booking";
		
		this.booking=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class));
		return this.booking;	
		
	}
	
	//Getting Booking by Booking ID
	
	public List<Booking> getBookingById(int id)
	{
		String sql="SELECT * FROM dbo.getBooking("+Integer.toString(id) +")";
		this.booking=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Booking.class));
		return this.booking;	
		
	}
	
	//ADD BOOKING
	
	public List<Status> AddBooking(String Email,String ContactNumber,String ResidentialAddress,String DateofTravel,int NumberofAdults,int NumberofChildren)
	{
		String sql="Declare @Result int\r\n"
				+ "EXEC @Result=dbo.uspBooking @Email= '"+Email+"',@ContactNumber='"+ContactNumber+"',@ResidentialAddress='"+ResidentialAddress+"',@DateofTravel='"+DateofTravel+"',@NumberofAdults="+Integer.toString(NumberofAdults)+",@NumberofChildren="+Integer.toString(NumberofChildren)+",@BookingStatus='Pending'"+"\r\n"
				+ "select @Result AS Result;";
		 this.result=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Status.class));
		return result;	
		
	}
	
	
	//Updating Booking Status by BookingID
	
	public List<Status> UpdateBookingById(int id)
	{
		String sql="Declare @Result int\r\n"
				+ "EXEC @Result=dbo.UpdateBstatus @BookingId ="+Integer.toString(id)+"\r\n"
				+ "select @Result AS Result;";
		 this.result=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Status.class));
		return result;	
		
	}
	
	
	//Deleting Booking by BookingID
	
	public List<Status> DeleteBookingById(int id)
	{
		String sql="Declare @Result int\r\n"
				+ "EXEC @Result=dbo.DeleteBooking @BookingId ="+Integer.toString(id)+"\r\n"
				+ "select @Result AS Result;";
		 this.result=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Status.class));
		return result;	
		
	}
	

}
