package com.wecaremeals.controller;

import com.wecaremeals.dao.DonorDAO;
import com.wecaremeals.dao.DonorDAOImpl;
import com.wecaremeals.dto.Donor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donorRegister")
public class DonorRegistrationServlet extends HttpServlet {

    DonorDAO ddao=null;

    public DonorRegistrationServlet(){
        ddao=new DonorDAOImpl();
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int donorId= Integer.parseInt(req.getParameter("donorId"));
        String name=req.getParameter("name");
        long phone= Long.parseLong(req.getParameter("phone"));
        String password=req.getParameter("password");
        String address=req.getParameter("address");

        Donor donor= new Donor(donorId,name,phone,password,address);

        boolean isRegistered= false;
        try {
            isRegistered = ddao.registerDonor(donor);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(isRegistered){
            req.getRequestDispatcher("donorLogin.html").forward(req,resp);

        }
        else{
            req.getRequestDispatcher("donorRegistration.html").forward(req,resp);
        }

    }
}
