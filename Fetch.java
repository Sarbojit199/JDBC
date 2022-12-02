package com.sms.students.fetch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sms.Helper;

public class Fetch {
	
	public void fetchMenudriven() throws SQLException{
		Connection conn = Helper.con();
		Statement stmt = conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from sms_details");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}

}
