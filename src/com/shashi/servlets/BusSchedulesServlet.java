package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/busschedules")
public class BusSchedulesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String connectionString = "jdbc:mysql://localhost:3306/RESERVATION";
    private static final String username = "RESERVATION";
    private static final String password = "MANAGER";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DriverManager.getConnection(connectionString, username, password)) {
            String query = "SELECT * FROM bus_schedules";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Bus Schedules</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h2>Bus Schedules</h2>");
            out.println("<table class=\"table table-striped\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Route Name</th>");
            out.println("<th>Departure Time</th>");
            out.println("<th>Arrival Time</th>");
            out.println("<th>Distance (km)</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("route_name") + "</td>");
                out.println("<td>" + rs.getTime("departure_time") + "</td>");
                out.println("<td>" + rs.getTime("arrival_time") + "</td>");
                out.println("<td>" + rs.getFloat("distance_km") + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}
