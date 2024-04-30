package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelDao {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public boolean cancel(String userId) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement("UPDATE BookingBus SET STATUS=? WHERE UID=?")) {
            pstmt.setString(1, "cancel");
            pstmt.setString(2, userId);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or throw exception as appropriate
            return false;
        }
    }
}
