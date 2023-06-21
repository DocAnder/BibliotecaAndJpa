package com.example.bibliotecaandjpa.controllers;

import com.example.bibliotecaandjpa.domain.entities.User;
import com.example.bibliotecaandjpa.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreatNewUserServlet", value = "/CreatNewUserServlet")
public class CreateNewUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userType = request.getParameter("userType");
        String userPassword = request.getParameter("userPassword");

        if (userName.isEmpty() || userName == null || userEmail.isEmpty() || userEmail == null || userType.isEmpty() || userType == null || userPassword.isEmpty() || userPassword == null){
            response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/createUser.jsp?msg=Empity");
        }else{

            user.setName(userName);
            user.setEmail(userEmail);
            user.setType(userType);
            user.setPassword(userPassword);
            UserRepository userRepository = new UserRepository();
            userRepository.create(user);

            response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet");

        }





    }


}
