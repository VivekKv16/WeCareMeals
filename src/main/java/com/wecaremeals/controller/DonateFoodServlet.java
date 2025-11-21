package com.wecaremeals.controller;

import com.wecaremeals.util.DbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/donateFood")
public class DonateFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int donorID = Integer.parseInt(request.getParameter("donorID"));
        String foodItem = request.getParameter("foodItem");
        String quantity = request.getParameter("quantity");

        try (Connection conn = DbConnection.getConnection()) {

            String sql = "INSERT INTO food_donations (donorID, foodItem, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, donorID);
            ps.setString(2, foodItem);
            ps.setString(3, quantity);

            ps.executeUpdate();

            response.sendRedirect("donorDashboard.jsp?success=true");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
