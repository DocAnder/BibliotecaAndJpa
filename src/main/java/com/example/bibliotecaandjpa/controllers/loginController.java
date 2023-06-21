package com.example.bibliotecaandjpa.controllers;

import com.example.bibliotecaandjpa.utils.LoginChecker;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/LoginControllerServlet", "/login"})
public class loginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        String password = req.getParameter("password");


        LoginChecker loginChecker = new LoginChecker();


        try {
            loginChecker.loginValidate(user, password, req);
            resp.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet");

        }catch (Exception e){
            String msg = e.getMessage();
            System.out.println(msg);
            resp.sendRedirect("http://localhost:8080/BibliotecaAndJpa/index.jsp?msg=" + msg);
        }

    }


}
