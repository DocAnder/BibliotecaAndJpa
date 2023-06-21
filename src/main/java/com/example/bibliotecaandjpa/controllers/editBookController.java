package com.example.bibliotecaandjpa.controllers;


import com.example.bibliotecaandjpa.domain.entities.Autor;
import com.example.bibliotecaandjpa.domain.entities.Livro;
import com.example.bibliotecaandjpa.domain.enums.Status;
import com.example.bibliotecaandjpa.repository.AutorRepository;
import com.example.bibliotecaandjpa.repository.LivroRepository;
import com.example.bibliotecaandjpa.repository.UserRepository;
import com.example.bibliotecaandjpa.utils.DateFormater;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditControllerServlet", value = "/EditControllerServlet")
public class editBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("codigo");
        System.out.println("Codigo do Livro vindo da List: " + id);
        LivroRepository livroRepository = new LivroRepository();
        request.setAttribute("livro", livroRepository.findById(Integer.parseInt(id)));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editBook.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookName = req.getParameter("bookName");
        String autorName = req.getParameter("autorName");
        String status = req.getParameter("status");
        String data = req.getParameter("date");


        if (bookName.isEmpty() || bookName == null || autorName.isEmpty() || autorName == null || status.isEmpty() || status == null || data.isEmpty() || data == null){

            String id = req.getParameter("codigo");
            System.out.println("Codigo do Livro vindo da EditBook: " + id);
            LivroRepository livroRepository = new LivroRepository();
            req.setAttribute("livro", livroRepository.findById(Integer.parseInt(id)));
            req.setAttribute("msg", "notSave");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("editBook.jsp");
            requestDispatcher.forward(req, resp);

        }else{


            AutorRepository autorRepository = new AutorRepository();
            LivroRepository livroRepository = new LivroRepository();
            Livro livro = livroRepository.findById(Integer.parseInt(req.getParameter("codigo")));
            Autor autor = autorRepository.findByName(req.getParameter("autorName"));

            if(autor == null){
                autor = new Autor();
                autor.setNome(req.getParameter("autorName"));
                autor = autorRepository.create(autor);
                livro.setNome(req.getParameter("bookName"));
                livro.setDate(DateFormater.stringParaData(req.getParameter("date")));
                livro.setAutor(autor);
                livro.setStatus(Status.valueOf(req.getParameter("status").toUpperCase()));
                livroRepository.update(livro);
            }else{
                livro.setNome(req.getParameter("bookName"));
                livro.setDate(DateFormater.stringParaData(req.getParameter("date")));
                livro.setAutor(autor);
                livro.setStatus(Status.valueOf(req.getParameter("status").toUpperCase()));
                livroRepository.update(livro);
            }

            resp.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet");



        }






    }




}
