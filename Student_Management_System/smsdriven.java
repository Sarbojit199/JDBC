package com.sms.students;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sms.Helper;

public class smsdriven {
	public Scanner s= new Scanner(System.in);
	public int s_id;
	public String s_name,s_address;
	
	//saving employee details in database
	
	public void savesmsdriven() throws SQLException{
		System.out.println("Enter student s_Id :");
		s_id =s.nextInt();
		
		System.out.println("Enter student name:");
		s_name =s.next();
		
		System.out.println("Enter student address :");
		s_address =s.next();
		
		Connection conn= Helper.con();
		System.out.println("connection done");
		PreparedStatement stmt = conn.prepareStatement("insert into sms_details values(?,?,?)");
		System.out.println("field introduced");
		
		stmt.setInt(1, s_id);
		stmt.setString(2, s_name);
		
		stmt.setString(3, s_address);
		stmt.execute();
		System.out.println("successfully inserted");
		
		ResultSet rs= stmt.executeQuery("select * from sms_details");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" " +rs.getString(3));
		}
		
	}
	

}

