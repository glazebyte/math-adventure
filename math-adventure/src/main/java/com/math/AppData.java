package com.math;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppData {
    private static String db_url = "jdbc:mysql://localhost/mathadventure";
    private static String dbuser = "root";
    private static String pass = "makan";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(db_url,dbuser,pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static User LoginUser(String username, String password){
        Connection conn = connect();
        User user = null;
        boolean admin = false;
        String sql = "SELECT * FROM USER WHERE Username = ? AND PASSWORD = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("Role"));
                admin = rs.getString("Role").equals("Admin");
                user = new User(rs.getString("Username"), admin);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
