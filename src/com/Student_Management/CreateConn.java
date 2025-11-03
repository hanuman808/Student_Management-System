package com.Student_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConn {
	public static Connection CreateDB() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagement","root","2004");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}

}
