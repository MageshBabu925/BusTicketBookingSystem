package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingInfo {
    public List<Bookinfo> allBookInfo() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Bookinfo> info = new ArrayList<>();
        try {
            String query = "jdbc:mysql://localhost:3306/servlet?useSSL=false"; // Specify the database name and add useSSL=false if not using SSL
            String user = "root";
            String pwd = "root";
            String sql = "select * from BookingBus where STATUS=?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(query, user, pwd);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "pending");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Bookinfo i = new Bookinfo();
                i.setUserId(rs.getInt(1));
                i.setBno(rs.getString(2));
                i.setBtype(rs.getString(3));
                i.setStart(rs.getString(4));
                i.setDestination(rs.getString(5));
                i.setStartTime(rs.getString(6));
                i.setEndTime(rs.getString(7));
                info.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle or log the exception appropriately
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return info;
    }
}
