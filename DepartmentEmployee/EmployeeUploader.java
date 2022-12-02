package com.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.helper.Helper;


class DuplicateDataException extends Exception{
	public DuplicateDataException(String str) {
		super(str);
	}
}
class LessSalaryAmountException extends Exception{
	public LessSalaryAmountException(String str) {
		super(str);
	}
}
class DepartmentNotFoundException extends Exception{
	public DepartmentNotFoundException(String str) {
		super(str);
	}
}
public class EmployeeUploader {
	Scanner s= new Scanner(System.in);
	int d_id; String d_name, d_head,d_desc;
	
	int ee_id; String ee_name; String ee_address; long ee_salary; long ee_contact_No;
	public void storeEmployeedetails() throws SQLException, DuplicateDataException, LessSalaryAmountException, DepartmentNotFoundException{
	System.out.println("Enter employee id: ");
	  ee_id=s.nextInt();
	System.out.println("Enter employee name: ");
	 ee_name =s.next();
	System.out.println("Enter address: ");
	  ee_address =s.next();
	System.out.println("Enter salary: ");
	 ee_salary =s.nextLong();
	System.out.println("Enter  contact no: ");
	 ee_contact_No =s.nextLong();
	System.out.println("Enter depertment id: ");
	 d_id=s.nextInt();
	Connection conn= Helper.con();
	System.out.println("connection done");
	PreparedStatement stmt = conn.prepareStatement("insert into employeee values(?,?,?,?,?,?)");
	System.out.println("field introduced");
	stmt.setInt(1, ee_id);
	stmt.setString(2, ee_name);
	stmt.setString(3, ee_address);
	stmt.setLong(4, ee_salary);
	stmt.setLong(5, ee_contact_No);
	stmt.setInt(6, d_id);
	stmt.execute();
	if((d_id==ee_id) || (d_name==ee_name)){
	throw new DuplicateDataException("employee already exists");
	}
	if(ee_salary<1000) {
		throw new LessSalaryAmountException("salary cannot be less than 1000");
	}
	if(d_id==0) {
		throw new DepartmentNotFoundException("department does not exists");
	}
	
	System.out.println("successfully inserted");
	
	}
	
	public void retrieveDeptdetails() throws SQLException{
		System.out.println("Enter the dept id u want to retreive  details from employee and department");
		int dd_id=s.nextInt();

		Connection conn=Helper.con();
		Statement stmt=conn.createStatement(); 
		ResultSet rs= stmt.executeQuery("select employeee.ee_name,department.d_name,department.d_head  from department,employeee where department.d_id="+dd_id);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		
		}}
	public void storeDepartmentdetails() throws SQLException{
		
		System.out.println("Enter depertment id: ");
		 d_id=s.nextInt();
		 System.out.println("Enter depertment name: ");
		 d_name =s.next();
		 System.out.println("Enter depertment head: ");
		 d_head =s.next();
		System.out.println("Enter depertment description: ");
		 d_desc =s.next();
		Connection conn= Helper.con();
		System.out.println("connection done");
		PreparedStatement stmt = conn.prepareStatement("insert into department values(?,?,?,?)");
		System.out.println("field introduced");
		stmt.setInt(1, d_id);
		stmt.setString(2, d_name);
		stmt.setString(3, d_head);
		stmt.setString(4, d_desc);
		stmt.execute();
		System.out.println("successfully inserted");
		ResultSet rs= stmt.executeQuery("select * from department");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" " +rs.getString(3)+" "+rs.getString(4));
		}
}
		
		
	
	public void calculatePF(int ee_id) throws SQLException{
		Connection conn =Helper.con();
		Statement stmt =conn.createStatement();
		System.out.println(+ee_id);
		
		ResultSet rs = stmt.executeQuery("select ee_salary from employeee where ee_id="+ee_id);
		while(rs.next()) {
			ee_salary=rs.getLong(1);
			System.out.println(ee_salary);					//calculating pf
			if(ee_salary>=100.00 && ee_salary<1500) {
				float pf =(ee_salary*5)/100;
				System.out.println("your pf is :" +pf);
			}
			if(ee_salary>=1500.00 && ee_salary<2000) {
				float pf =(ee_salary*6)/100;
				System.out.println("your pf is :" +pf);
			}
			if(ee_salary>=2000.00) {
				float pf =(ee_salary*7)/100;
				System.out.println("your pf is :" +pf);
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args) throws SQLException{
		EmployeeUploader eu= new  EmployeeUploader();
				Scanner scan =new Scanner(System.in); 
		System.out.println("""
				Press 1 for Insert Department Records : 
				Press 2 for Insert Employee Records :
				Press 3 for Display Records :
				Press 4 for checking pf :
				Press 5 for Exit : 
				""");
		int variable = scan.nextInt();
		System.out.println("-------------------------------");
		switch(variable) {
		case 1 : 
		  eu.storeDepartmentdetails();
		  break;
		case 2 :  
			try {
				eu.storeEmployeedetails();
			} catch (SQLException | DuplicateDataException | LessSalaryAmountException
					| DepartmentNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3 :
			eu.retrieveDeptdetails();
			break;
		case 4 :
			System.out.println("Enter employee id");
			int id= scan.nextInt();
			eu.calculatePF(id);;
			break;
		case 5 :
			System.exit(0);
			break;
		}
	}}
		
	
	
		






