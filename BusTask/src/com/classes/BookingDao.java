package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
public boolean booking(String userId, String busNo, String busType, String start, String destination, String startTime, String endTime,String status) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		
		try {
			String query = "jdbc:mysql://localhost:3306/servlet";
	        String user = "root";
	        String pwd = "root";
	        String sql = "insert into BookingBus(UID, BUS_NO, BUS_TYPE, START, DESTINATION, START_TIME, END_TIME, STATUS) VALUES(?,?,?,?,?,?,?,?)";
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        con = DriverManager.getConnection(query, user, pwd);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userId);
	        pstmt.setString(2, busNo);
	        pstmt.setString(3, busType);
	        pstmt.setString(4, start);
	        pstmt.setString(5, destination);
	        pstmt.setString(6, startTime);
	        pstmt.setString(7, endTime);
	        pstmt.setString(8, status);
	        i = pstmt.executeUpdate();
	        if(i > 0) {
	        	return true;
	        }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
		
		return false;
	}

@SuppressWarnings("unchecked")
public List<Bookinfo> getBookingHistory(String user) {
	List<Bookinfo> book = new ArrayList<>();
	 String query = "jdbc:mysql://localhost:3306/servlet";
     String user1 = "root";
     String pwd = "root";
     String sql = "SELECT * FROM BookingBus WHERE UID=?";
     
     try{
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 Connection con = DriverManager.getConnection(query, user1, pwd);
    	 PreparedStatement pstmt = con.prepareStatement(sql);
    	 pstmt.setInt(1, userId); 
    	 ResultSet rs = pstmt.executeQuery();
    	 if (rs.next()) {
    		 Bookinfo b = new Bookinfo();
    		 b.setUserId(rs.getInt(1));
    		 b.setBno(rs.getString(2));
    		 b.setBtype(rs.getString(3));
         	 b.setStart(rs.getString(4));
         	 b.setDestination(rs.getString(5));
         	 b.setStartTime(rs.getString(6));
         	 b.setEndTime(rs.getString(7));
         	 b.setStatus(rs.getString(8));
         	 return (List<Bookinfo>) b;
    	 }

    } 
     catch (SQLException e)
     {
        e.printStackTrace(); 
     }
    return book;
}
}
