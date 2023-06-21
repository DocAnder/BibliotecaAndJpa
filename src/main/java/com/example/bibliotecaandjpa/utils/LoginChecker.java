package com.example.bibliotecaandjpa.utils;


import com.example.bibliotecaandjpa.domain.entities.Autor;
import com.example.bibliotecaandjpa.domain.entities.User;
import com.example.bibliotecaandjpa.repository.UserRepository;
import jakarta.persistence.NoResultException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class LoginChecker {

    public void loginValidate(String user, String password, HttpServletRequest request) throws Exception {

        if(user.isEmpty() || user == null || password.isEmpty() || password == null){
            throw  new Exception("Preencha os campos com email e senha!");
        }else{
            try{
                User usuario;
                UserRepository userRepository = new UserRepository();
                usuario = userRepository.findByEmail(user);
                if(user.equals(usuario.getEmail()) && password.equals(usuario.getPassword())){
                    HttpSession session = request.getSession();
                    session.setAttribute("is_logged_in", true);
                    session.setAttribute("user", usuario);
                }else {
                    throw new Exception("Usuario ou senha incorretos!");
                }
            }catch (NoResultException e){
                throw new NoResultException("Usuario nao cadastrado!");
            }

        }




    }



}
