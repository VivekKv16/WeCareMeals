package com.wecaremeals.controller;

import com.wecaremeals.dao.NgoDAO;
import com.wecaremeals.dao.NgoDAOImpl;
import com.wecaremeals.dto.Donor;
import com.wecaremeals.dto.Ngo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/loadNgo")
public class LoadNgoServlet extends HttpServlet {

    NgoDAO ngoDAO = new NgoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        Donor donor = (Donor) session.getAttribute("donor");

        if (donor == null) {
            resp.sendRedirect("donorLogin.html");
            return;
        }

        try {
            List<Ngo> ngoList = ngoDAO.getNgoByAddress(donor.getAddress());
            req.setAttribute("ngoList", ngoList);

            req.getRequestDispatcher("donorDashboard.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
