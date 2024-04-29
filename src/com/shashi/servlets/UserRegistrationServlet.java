package com.shashi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String url = "jdbc:mysql://localhost:3306/RESERVATION";
    private static final String username = "RESERVATION";
    private static final String password = "MANAGER";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String email = request.getParameter("mailid");
        String password = request.getParameter("pword");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String phoneno = request.getParameter("phoneno");
        
        // Database connection and insertion
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO users (email, password, firstname, lastname, address, phoneno) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                pstmt.setString(3, firstname);
                pstmt.setString(4, lastname);
                pstmt.setString(5, address);
                pstmt.setString(6, phoneno);
                
                int rowsInserted = pstmt.executeUpdate(); // Use executeUpdate instead of executeQuery
                if (rowsInserted > 0) {
                    response.getWriter().println("User registered successfully!");
                } else {
                    response.getWriter().println("Failed to register user!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database operation failed", e);
        }
    }
}
