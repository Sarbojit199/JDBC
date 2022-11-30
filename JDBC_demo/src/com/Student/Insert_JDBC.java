package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_JDBC {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");			//registering
		//creating connection
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","567890");	
		
		System.out.println("connection done");
		
		//3.create statement
		Statement stmt= con.createStatement();
		System.out.println("create statement");
		
		//first time execute we use execute
		//inserting into the database
		stmt.execute("insert into student_manage values(1,'sarbo',12345678,'kolkata')");
	//	5. closing connection
		
		
		con.close();
		
		
	}
	catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
	}
}
}
