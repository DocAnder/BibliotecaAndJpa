package com.example.bibliotecaandjpa.repository;

import com.example.bibliotecaandjpa.connection.ConnectionFactory;
import com.example.bibliotecaandjpa.domain.entities.Autor;
import com.example.bibliotecaandjpa.domain.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;

public class AutorRepository {


    private EntityManager entityManager;
    private EntityTransaction transaction;

    public AutorRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Autor create(Autor autor){
        transaction.begin();
        entityManager.persist(autor);
        transaction.commit();
        return autor;
    }

    public Autor findById(Integer id){

        Autor autor = entityManager.find(Autor.class, id);

        return autor;
    }

    public Autor update(Autor autor){

        transaction.begin();

        autor = entityManager.merge(autor);

        transaction.commit();

        return autor;

    }


    public Autor remove(Autor autor){

        if(autor == null){
            throw new RuntimeException("Autor não pode ser nulo");
        }

        transaction.begin();

        autor = entityManager.find(Autor.class, autor.getId());

        entityManager.remove(autor);

        transaction.commit();

        return autor;
    }

    public List<Autor> findAll(){
        return entityManager.createQuery("SELECT a FROM Autor a").getResultList();
    }

    //Importante notar que ao não o objeto no banco, irá lançar uma exceção.
    //Ou seja, não irá retornar um objeto nulo mais sim lançará uma exceção.
    public Autor findByName(String nome) throws NoResultException {
        try{
            return entityManager.createQuery("SELECT a FROM Autor a WHERE a.nome = :nome", Autor.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println("Nenhum autor encontrado!" + e.getMessage());
            Autor autor = null;
            return autor;
        }



    }






}
