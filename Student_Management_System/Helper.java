package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.sms.students.smsdriven;
import com.sms.students.fetch.Fetch;
import com.sms.students.test.Test;
import com.update.Delete;

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
		//	smsdriven sd= new smsdriven();
		//	sd.savesmsdriven(); 
			
			//Test t=new Test();
			//t.updateMenudriven();
			
		////	Delete d= new Delete();
			//d.deleteMenudriven();
			
			
		//	Fetch f= new Fetch();
		//	f.fetchMenudriven(); 
			
			
			smsdriven s=new smsdriven();
			Fetch f=new Fetch();
		 Test t = new Test();
		 
		 Delete d= new Delete();
			Scanner scan =new Scanner(System.in); 
			System.out.println("""
					Press 1 for Insert : 
					Press 2 for Display :
					Press 3 for Update :
					Press 4 for Delete :
					Press 5 for Exit : 
					""");
			int variable = scan.nextInt();
			System.out.println("-------------------------------");
			switch(variable) {
			case 1 : 
			  s.savesmsdriven();
			  break;
			case 2 :  
				f.fetchMenudriven();
				break;
			case 3 :
				t.updateMenudriven();
				break;
			case 4 :
				d.deleteMenudriven();
				break;
			case 5 :
				System.exit(0);
				break;
			}
		}
			
		
	}


