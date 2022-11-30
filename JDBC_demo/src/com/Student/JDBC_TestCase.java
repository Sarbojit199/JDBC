package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_TestCase {

	public static void main(String[] args) {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","567890");
				Statement stmt= con.createStatement();

				//execute the fetch query from database
				ResultSet rs= stmt.executeQuery("select * from student_manage");
				System.out.println("selected tables");
				
				//print the tables
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
				}

				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
		}
		
	

}}
