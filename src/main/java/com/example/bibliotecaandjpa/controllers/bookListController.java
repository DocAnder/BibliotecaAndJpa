package com.example.bibliotecaandjpa.controllers;

import com.example.bibliotecaandjpa.repository.LivroRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "booksListServlet", value = "/booksListServlet")
public class bookListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        LivroRepository livroRepository = new LivroRepository();
        req.setAttribute("livros", livroRepository.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("booksList.jsp");
        requestDispatcher.forward(req, resp);

    }


}
