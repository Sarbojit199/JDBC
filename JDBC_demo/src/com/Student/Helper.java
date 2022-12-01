package com.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {

		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
		}
		
		public static Connection con() throws SQLException{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","567890");
		}
		public static void main(String args[]) throws SQLException{
			Menudriven md= new Menudriven();
			md.saveMenudriven();
			md.fetchMenudriven();
			md.updateMenudriven();
			md.deleteMenudriven();
		
		}
	}


