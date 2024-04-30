package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    
    public Record login(String uname, String password) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            String query = "jdbc:mysql://localhost:3306/servlet";
            String user = "root";
            String pwd = "root";
            String sql = "select UID,ROLL from UserRegistration where UNAME=? AND PASSWORD=?";
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection(query, user, pwd);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
            	Record r = new Record();
            	r.setuId(rs.getInt("UID"));
            	r.setRoll(rs.getString("ROLL"));
            	return r;
            }
            
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        return null; // Return "user" if no matching record is found
    }
    
}
