package com.project.leebugzz.model;

 

import java.io.IOException;

 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

public class Login_Servlet extends HttpServlet {
    
protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
    
    String username =  request.getParameter("username");
    String password = request . getParameter("password");
    if(username.isEmpty()|| password.isEmpty())
    {
        RequestDispatcher req = request.getRequestDispatcher("login.jsp");
        req.include(request, response);
    }
    else {
        RequestDispatcher req = request.getRequestDispatcher("dashboard.jsp");
        req.forward(request, response);
    }
    
}

 

}