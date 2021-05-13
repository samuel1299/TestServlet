package com.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;

import java.sql.Connection;

public class ClassDao {
     
	String sql = "select * from login where username =? and pass =?";
	String url = "jdbc:mysql://localhost:3306/sam";
	String username = "root";
    String password =  "Samuel@12";			
	public boolean check(String username, String pass)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		Connection con = DriverManager.getConnection(url,username,password );
		java.sql.PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, pass);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			
			return true;
		}
		
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
		
		
		return false;
		
	}
}
