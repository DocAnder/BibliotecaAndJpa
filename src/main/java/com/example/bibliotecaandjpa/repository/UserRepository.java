package com.example.bibliotecaandjpa.repository;

import com.example.bibliotecaandjpa.connection.ConnectionFactory;
import com.example.bibliotecaandjpa.domain.entities.Autor;
import com.example.bibliotecaandjpa.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UserRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public UserRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public User create(User user){
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    //Importante notar que ao não encontrar o objeto no banco, irá lançar uma exceção.
    //Ou seja, não irá retornar um objeto nulo mais sim lançará uma exceção.
    public User findByEmail(String email) throws NoResultException {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }




}
