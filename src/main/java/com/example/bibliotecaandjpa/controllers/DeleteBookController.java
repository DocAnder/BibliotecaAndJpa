package com.example.bibliotecaandjpa.controllers;

import com.example.bibliotecaandjpa.repository.LivroRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "DeleteBookControllerServlet", value = "/DeleteBookControllerServlet")
public class DeleteBookController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String status = request.getParameter("status");
        System.out.println("ID" + id);
        System.out.println("STATUS" + status);
        if(status.equals("INDISPONIVEL")){
            LivroRepository livroRepository = new LivroRepository();
            livroRepository.remove(livroRepository.findById(Integer.parseInt(id)));
            response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet");
        }else{
            response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet?msg=notAllowed");
        }


    }





}
