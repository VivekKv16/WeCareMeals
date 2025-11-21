package com.wecaremeals.controller;

import com.wecaremeals.dao.DonorDAO;
import com.wecaremeals.dao.DonorDAOImpl;
import com.wecaremeals.dto.Donor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/donorAddress")
public class DonorAddressServlet extends HttpServlet {

    DonorDAO ddao = new DonorDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Donor donor = (Donor) session.getAttribute("donor");
        if (donor == null) {
            resp.sendRedirect("donorLogin.html");
            return;
        }

        String newAddress = req.getParameter("address");

        try {
            ddao.updateAddress(donor.getDonorId(), newAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Update session
        session.setAttribute("address", newAddress);
        donor.setAddress(newAddress);

        resp.sendRedirect("donorDashboard.jsp");
    }
}
