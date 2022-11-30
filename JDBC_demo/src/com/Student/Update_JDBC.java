package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_JDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			//registering
			//creating connection
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","567890");	
			
			System.out.println("connection done");
			
			//3.create statement
			Statement stmt= con.createStatement();
			System.out.println("create statement");
			//update the existing record
			stmt.executeUpdate("update student_manage set s_address='delhi' where s_id=2");
			stmt.executeUpdate("update student_manage set s_phone=5678 where s_id=1");
			
			//delete query
			stmt.executeUpdate("delete from student_manage where s_id=5");
			
			System.out.println("query updated");
			//	5. closing connection
			//execute the fetch query from database
			ResultSet rs= stmt.executeQuery("select * from student_manage");
			System.out.println("selected tables");
			
			//print the tables
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
			con.close();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}


	}

}
