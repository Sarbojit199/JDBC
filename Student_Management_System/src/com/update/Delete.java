package com.update;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sms.Helper;

public class Delete {
	Scanner s=new Scanner(System.in);

	
	public void deleteMenudriven()throws SQLException{
		
		
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement();
		System.out.println("Enter employee id : ");
		int s_id = s.nextInt();
		stmt.executeUpdate("delete from sms_details where s_id="+s_id);	
		ResultSet rs=stmt.executeQuery("select * sms_details");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));			
		}	
	}

	



}