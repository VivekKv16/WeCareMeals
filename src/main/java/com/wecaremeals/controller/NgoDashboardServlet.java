package com.wecaremeals.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import com.wecaremeals.dto.Ngo;
import com.wecaremeals.dto.Donation;
import com.wecaremeals.dao.DonationDAO;
import com.wecaremeals.dao.DonationDAOImpl;

@WebServlet("/ngodashboard")
public class NgoDashboardServlet extends HttpServlet {

    private DonationDAO donationDAO = new DonationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Ngo ngo = (Ngo) session.getAttribute("ngo");

        if (ngo == null) {
            response.sendRedirect("ngoLogin.html");
            return;
        }

        int ngoId = ngo.getNgoId();
        System.out.println("NGO Dashboard for NGO ID = " + ngoId);

        List<Donation> donationList = donationDAO.getDonationsForNgo(ngoId);
        System.out.println("Donations found: " + donationList.size());

        request.setAttribute("donationList", donationList);
        request.getRequestDispatcher("ngodashboard.jsp").forward(request, response);
    }
}
