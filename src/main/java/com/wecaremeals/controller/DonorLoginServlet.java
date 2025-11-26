package com.wecaremeals.controller;

import com.wecaremeals.dao.DonorDAO;
import com.wecaremeals.dao.DonorDAOImpl;
import com.wecaremeals.dto.Donor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donorLogin")
public class DonorLoginServlet extends HttpServlet {

    DonorDAO ddao=null;

    public DonorLoginServlet(){
        ddao= new DonorDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long phone = Long.parseLong(req.getParameter("phone"));
        String password=req.getParameter("password");
        System.out.println("DonorLoginServlet");
        System.out.println("donorrrr");
        Donor donor=null;

        try {
            donor=ddao.loginDonor(phone,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(donor != null){
            HttpSession session = req.getSession();
            session.setAttribute("donor", donor);
            session.setAttribute("address", donor.getAddress());
            resp.sendRedirect("loadNgo");
        }

//            req.getRequestDispatcher("donorDashboard.jsp").forward(req, resp);
//            resp.sendRedirect("loadNgo");

        }


    }

