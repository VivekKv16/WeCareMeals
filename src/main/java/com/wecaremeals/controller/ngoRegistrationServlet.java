package com.wecaremeals.controller;

import com.wecaremeals.dao.DonorDAO;
import com.wecaremeals.dao.DonorDAOImpl;
import com.wecaremeals.dao.NgoDAO;
import com.wecaremeals.dao.NgoDAOImpl;
import com.wecaremeals.dto.Donor;
import com.wecaremeals.dto.Ngo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ngoRegister")
public class ngoRegistrationServlet extends HttpServlet {

    NgoDAO ndao=null;

    public ngoRegistrationServlet() {
        ndao=new NgoDAOImpl();
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ngoId= Integer.parseInt(req.getParameter("ngoId"));
        String name=req.getParameter("name");
        long phone= Long.parseLong(req.getParameter("phone"));
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String address=req.getParameter("address");

        Ngo ngo= new Ngo(ngoId,name,phone,password,email,address);

        boolean isRegistered= false;
        try {
            isRegistered = ndao.registerNgo(ngo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(isRegistered){
            req.getRequestDispatcher("ngoLogin.html").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("ngoRegistration.html").forward(req,resp);
        }

    }
}
