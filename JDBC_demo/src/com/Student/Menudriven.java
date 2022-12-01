package com.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menudriven {
	

		
		Scanner s= new Scanner(System.in);
		int e_id,e_age,e_salary;
		String e_name,e_city;
		
		//saving employee details in database
		
		public void saveMenudriven() throws SQLException{
			System.out.println("Enter Employee Id :");
			e_id =s.nextInt();
			
			System.out.println("Enter Employee name:");
			e_name =s.next();
			
			System.out.println("Enter Employee age :");
			e_age =s.nextInt();
			
			System.out.println("Enter Employee city :");
			e_city =s.next();
			
			System.out.println("Enter Employee salary :");
			e_salary =s.nextInt();
			
			Connection conn= Helper.con();
			System.out.println("connection done");
			PreparedStatement stmt = conn.prepareStatement("insert into menudrivendemo values(?,?,?,?,?)");
			System.out.println("field introduced");
			
			stmt.setInt(1, e_id);
			stmt.setString(2, e_name);
			stmt.setInt(3, e_age);
			stmt.setString(4, e_city);
			stmt.setInt(5, e_salary);
			stmt.execute();
			System.out.println("successfully inserted");
			
		}
		public void fetchMenudriven() throws SQLException{
			Connection conn = Helper.con();
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery("select * from menudrivendemo");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
			}
		}

		 public void updateMenudriven()throws SQLException{
	        	Connection conn=Helper.con();
				Statement stmt=conn.createStatement(); 
				System.out.println("enter employee city : ");
				e_city=s.nextLine();
				stmt.executeUpdate("update menudriven set e_city='"+e_city+"' where e_id="+e_id);
	        }
	//deleting
				public void deleteMenudriven()throws SQLException{
		        	Connection conn=Helper.con();
					Statement stmt=conn.createStatement(); 
					System.out.println("enter employee id : ");
					e_id=s.nextInt();
					stmt.executeUpdate("delete from menudriven where e_id="+e_id);

	

				}}
