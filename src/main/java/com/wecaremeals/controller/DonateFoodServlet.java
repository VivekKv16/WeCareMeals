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
        int ngoID = Integer.parseInt(request.getParameter("ngoID"));

        String[] items = request.getParameterValues("foodItem");
        String[] qty = request.getParameterValues("quantity");

        try (Connection conn = DbConnection.getConnection()) {

            String sql = "INSERT INTO food_donations (donorID, ngoID, foodItem, quantity) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 0; i < items.length; i++) {
                ps.setInt(1, donorID);
                ps.setInt(2, ngoID);
                ps.setString(3, items[i]);
                ps.setString(4, qty[i]);
                ps.executeUpdate();
            }

            response.sendRedirect("loadNgo?success=true");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
