package com.jbk.Simple12Api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Connection.Conn;




@RestController
public class WebServices12API {
	//1
	@RequestMapping("showallemployee")
	public ArrayList<Employee> getShowAllEmployee() throws SQLException{
	
		ArrayList<Employee> al= new ArrayList<>();
		
	Connection con=Conn.getCon();
	System.out.println("Connection done");
	PreparedStatement ps=con.prepareStatement("select *from employee");
	ResultSet rs=ps.executeQuery();
	while(rs.next()) 
	{
		Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
				rs.getString(5),rs.getString(6),
				rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
		al.add(e);
		
	}
	return al;
	

}
	//2
	//active,inactive,suspended!!!!!!!!!!!!!!!!!!
	@RequestMapping("status/{status}")
	public ArrayList<Employee> getStatus(@PathVariable("status")String status) throws SQLException{
		ArrayList<Employee> al= new ArrayList<>();
		
		Connection con=Conn.getCon();
		PreparedStatement ps=con.prepareStatement("select *from employee where status=?");
		ps.setString(1,status);
		ResultSet rs=ps.executeQuery();
		
		
		while(rs.next()) 
		{
			Employee e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			al.add(e);
			
		}
		return al;
	}
	//3
	@RequestMapping("id/{id}")
	public ArrayList<Employee> getById(@PathVariable("id")int id) throws SQLException{
	ArrayList<Employee> al= new ArrayList<>();
	
	Connection con=Conn.getCon();
	PreparedStatement ps=con.prepareStatement("select *from employee where id=?");
	ps.setInt(1,id);
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		Employee e= new Employee (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
				rs.getString(5),rs.getString(6),
				rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
		al.add(e);
	}
		
		return al;
	}
	//4
	@RequestMapping("name/{name}")
	public ArrayList<Employee> getEmployeeByName(@PathVariable("name")String name) throws SQLException{
		ArrayList<Employee> al=new ArrayList<>();
		
		Connection con=Conn.getCon();
		PreparedStatement ps=con.prepareStatement("select *from employee where name=?");
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Employee e= new Employee (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			al.add(e);
		}
		return al;
	}
	//5
	@RequestMapping("/listofempbeforetoday/{createddtm}")
	public ArrayList<Employee> getEmployeeBeforeToday(@PathVariable("createddtm") String ddtm) throws SQLException{
		ArrayList<Employee> al=new ArrayList<>();
		
		Connection con=Conn.getCon();
		PreparedStatement ps=con.prepareStatement("select *from employee where createddtm=?");
		ps.setString(1,ddtm);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Employee e= new Employee (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			al.add(e);
		}
		return al;
	
	
	}
	//6
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee emp) throws SQLException {
		System.out.println(emp);
		Connection con=Conn.getCon();
		String sql="insert into employee(id,name,phone,department,status,createddtm,createdby,updateddtm,updatedby,cid) value(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,emp.getId());
		ps.setString(2,emp.getName());
		ps.setString(3,emp.getPhoneno());
		ps.setString(4,emp.getDepartmentit());
		ps.setString(5,emp.getStatus());
		ps.setString(6,emp.getCreateddtm());
		ps.setString(7,emp.getCreatedby());
		ps.setString(8,emp.getUpdateddtm());
		ps.setString(9,emp.getUpdatedby());
		ps.setInt(10,emp.getCid());
	
			int result=ps.executeUpdate();
	   if(result>0) {
		   
		   return "Employee Added Successfully";	
	   }
	   
	   else {
		   return "Something went wrong";
	   }
	}  
	//7
		@PostMapping("/addcountry")
				public String addCountry(@RequestBody country cou) throws SQLException {
			System.out.println(cou);
			Connection con=Conn.getCon();
			String sql="insert into country(cname) value(?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,cou.getCname());
			int result=ps.executeUpdate();
			
			 if(result>0) {
				   
				   return "Country Added Successfully";	
			   }
			   
			   else {
				   return "Something went wrong";
			   }
		 }
		//8
		//Update
		
		 @PutMapping("/updatecountryname")
			public String updatecountryname(@RequestBody country country) throws SQLException{
				System.out.println(111);
				Connection con=Conn.getCon();
				String sql="update country SET cname=? where cid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,country.getCname());
				ps.setInt(2,country.getCid());
				
			  int result=ps.executeUpdate();
			   if(result>0) {
				   
				   return "Country Updated Successfully";	
			   }
			   
			   else {
				   return "Something went wrong";
			   }
		   }//9
		//Delete
		
		@DeleteMapping("/deletebycountryname/{countryname}")
		public String DeletebyCountryName(@PathVariable("cname") String cname) throws SQLException 
		{
			
			Connection con=Conn.getCon();
			String sql="delete from country where cname=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,cname);
			int result=ps.executeUpdate();
			if(result>0) {
				return "Country name deleted";
			}
			else {
				return "Something went wrong";
			}
		}

		//10
			@DeleteMapping("deleteemployeebyid/{id}")
			public String DeleteEmployeeById(@PathVariable("id") int id) throws SQLException {
			
			Connection con=Conn.getCon();
			String Sql="delete from employee where id=?";
			PreparedStatement ps=con.prepareStatement(Sql);
			ps.setInt(1,id);
			int result=ps.executeUpdate();
			if(result>0) {
				return "Employee deleted successfully";
			}
			else {
				return "not deleted";
			}
			
		}
			
}
	
	

