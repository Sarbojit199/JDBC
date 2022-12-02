package com.sms.students.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.sms.Helper;
import com.sms.students.smsdriven;



public class Test {
	Scanner s= new Scanner(System.in);
	

	smsdriven s1= new smsdriven();
	 public void updateMenudriven()throws SQLException{
        	Connection conn=Helper.con();
			Statement stmt=conn.createStatement(); 
			System.out.println("enter which u want to insert");
			System.out.println("enter student name ");
			 String s_name= s.nextLine();
			 System.out.println("enter student id");
			 int s_id=s.nextInt();
			stmt.executeUpdate("update sms_details set s_name='"+s_name+"' where s_id="+s_id);
				ResultSet rs= stmt.executeQuery("select * from sms_details");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" " +rs.getString(3));
				}
	 }
	 		//deleting
			

}
