package com.wecaremeals.controller;

import com.wecaremeals.dao.NgoDAO;
import com.wecaremeals.dao.NgoDAOImpl;
import com.wecaremeals.dto.Ngo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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

        ngo=ndao.loginNgo(phone, password);

        if(ngo!=null){
            HttpSession session= req.getSession();

            session.setAttribute("ngo",ngo);
            req.getRequestDispatcher("ngoDashboard.jsp");
        }



    }
}
