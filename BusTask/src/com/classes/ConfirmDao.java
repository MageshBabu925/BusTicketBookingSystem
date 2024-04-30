package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConfirmDao {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public boolean confirm(String userId) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement("UPDATE BookingBus SET STATUS=? WHERE UID=?")) {
            pstmt.setString(1, "confirm");
            pstmt.setString(2, userId);
            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
