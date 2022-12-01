package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class ScannerJDBC {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		
		System.out.println("enter sid:");
		String s_id=s.next();
		System.out.println("enter sname:");
		String s_name=s.next();
		System.out.println("enter phone:");
		String s_phone=s.next();
		System.out.println("enter sadd:");
		String s_address=s.next();
		s.close();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","567890");	
			PreparedStatement stmt;
			String sql="insert into student_manage values(?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, s_id);
			stmt.setString(2, s_name);			//enter into that column
			stmt.setString(3, s_phone);
			stmt.setString(4, s_address);
			stmt.execute();
			System.out.println("inserted successfully");
			
			con.close();
			}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}}
}
