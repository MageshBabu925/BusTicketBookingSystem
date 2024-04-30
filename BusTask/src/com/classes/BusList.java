package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusList {
	  public List<Bus> buslist() {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        List<Bus> bus = new ArrayList<>();
	        try {
	            String query = "jdbc:mysql://localhost:3306/servlet";
	            String user = "root";
	            String pwd = "root";
	            String sql = "select * from NewBus";
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(query, user, pwd);
	            pstmt = con.prepareStatement(sql);

	            rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Bus b = new Bus();
	                b.setBid(rs.getString(1));
	                b.setBno(rs.getString(2));
	                b.setBtype(rs.getString(3));
	                b.setStart(rs.getString(4));
	                b.setDestination(rs.getString(5));
	                b.setStartTime(rs.getString(6));
	                b.setEndTime(rs.getString(7));
	                b.setAvalSeat(rs.getString(8));

	                bus.add(b);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pstmt != null) pstmt.close();
	                if (con != null) con.close();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }

	        return bus;
	    }
}
