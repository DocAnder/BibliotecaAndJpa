package com.example.bibliotecaandjpa.controllers;

import com.example.bibliotecaandjpa.domain.entities.Livro;
import com.example.bibliotecaandjpa.domain.enums.Status;
import com.example.bibliotecaandjpa.repository.LivroRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditStatusControllerServlet", value = "/EditStatusControllerServlet")
public class EditStatusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println("ID OBTIDO: " + id);
        String status = request.getParameter("status");
        System.out.println("STATUS OBTIDO: " + status.toUpperCase());

        LivroRepository livroRepository = new LivroRepository();
        Livro livro = livroRepository.findById(Integer.parseInt(id));
        livro.setStatus(Status.valueOf(status.toUpperCase()));
        livroRepository.update(livro);

        response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet");
    }





}
