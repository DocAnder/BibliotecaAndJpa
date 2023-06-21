package com.example.bibliotecaandjpa.controllers;

import com.example.bibliotecaandjpa.domain.entities.Autor;
import com.example.bibliotecaandjpa.domain.entities.Livro;
import com.example.bibliotecaandjpa.domain.enums.Status;
import com.example.bibliotecaandjpa.repository.AutorRepository;
import com.example.bibliotecaandjpa.repository.LivroRepository;
import com.example.bibliotecaandjpa.utils.DateFormater;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CreatNewBookServlet", value = "/CreatNewBookServlet")
public class createNewBookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookName = request.getParameter("bookName");
        String autorName = request.getParameter("autorName");
        String status = request.getParameter("status");
        String data = request.getParameter("floatingInput4");

        System.out.println("ENTRADA CREATEBOOKCONTROLER: " + bookName + " " + autorName + " " + status + " " + data);



        if (bookName.isEmpty() || bookName == null || autorName.isEmpty() || autorName == null || status.isEmpty() || status == null || data.isEmpty() || data == null){
            response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/creatBooks.jsp?msg=notSave");
        }else{

            AutorRepository autorRepository = new AutorRepository();
            LivroRepository livroRepository = new LivroRepository();
            Autor autor = autorRepository.findByName(request.getParameter("autorName"));
            Livro livro = new Livro();

            if(autor == null){
                autor = new Autor();
                autor.setNome(request.getParameter("autorName"));
                autor = autorRepository.create(autor);
                livro.setNome(bookName);
                livro.setDate(DateFormater.stringParaData(data));
                livro.setAutor(autor);
                livro.setStatus(Status.valueOf(status.toUpperCase()));
                livroRepository.create(livro);
            }else{
                livro.setNome(bookName);
                livro.setDate(DateFormater.stringParaData(data));
                livro.setAutor(autor);
                livro.setStatus(Status.valueOf(status.toUpperCase()));
                livroRepository.create(livro);
            }

            response.sendRedirect("http://localhost:8080/BibliotecaAndJpa/booksListServlet");
        }

    }



}
