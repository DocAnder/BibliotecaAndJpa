package com.example.bibliotecaandjpa;

import com.example.bibliotecaandjpa.domain.entities.Autor;
import com.example.bibliotecaandjpa.domain.entities.Livro;
import com.example.bibliotecaandjpa.domain.entities.User;
import com.example.bibliotecaandjpa.domain.enums.Status;
import com.example.bibliotecaandjpa.repository.AutorRepository;
import com.example.bibliotecaandjpa.repository.LivroRepository;
import com.example.bibliotecaandjpa.repository.UserRepository;
import com.example.bibliotecaandjpa.utils.DateFormater;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;


public class AppTest {


    public static void main(String[] args) {



//        AutorRepository autorRepository = new AutorRepository();
//        LivroRepository livroRepository = new LivroRepository();
//        Autor autor = autorRepository.findByName("Gepeto");
//
//        if(autor == null){
//            autor.setNome("Gepeto");
//            autor = autorRepository.create(autor);
//            Livro livro = livroRepository.findById(2);
//            livro.setNome(req.getParameter("bookName"));
//            livro.setDate(DateFormater.stringParaData(req.getParameter("date")));
//            livro.setAutor(autor);
//            livro.setStatus(Status.valueOf(req.getParameter("status").toUpperCase()));
//        }else{
//            Livro livro = livroRepository.findById(Integer.parseInt(req.getParameter("codigo")));
//            livro.setNome(req.getParameter("bookName"));
//            livro.setDate(DateFormater.stringParaData(req.getParameter("date")));
//            livro.setAutor(autor);
//            livro.setStatus(Status.valueOf(req.getParameter("status").toUpperCase()));
//        }









    }

}
