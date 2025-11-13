package com.wecaremeals.controller;

import com.wecaremeals.dao.NgoDAO;
import com.wecaremeals.dao.NgoDAOImpl;
import com.wecaremeals.dto.Ngo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/ngoLogin")
public class NgoLoginServlet extends HttpServlet {

    NgoDAO ndao =null;

    public NgoLoginServlet(){
        ndao=new NgoDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long phone= Long.parseLong(req.getParameter("phone"));
        String password=req.getParameter("password");
        Ngo ngo=null;
        System.out.println("hello");
        try {
            ngo=ndao.loginNgo(phone, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(ngo!=null){
            HttpSession session= req.getSession();

            session.setAttribute("ngo",ngo);
            req.getRequestDispatcher("ngoDashboard.jsp");
        }



    }
}
