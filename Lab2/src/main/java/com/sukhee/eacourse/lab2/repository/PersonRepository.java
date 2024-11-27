package com.sukhee.eacourse.lab2.repository;

import com.sukhee.eacourse.lab2.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PersonRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public PersonRepository(EmfSingleton emfSingleton) {
        emf = emfSingleton.getEmf();
        em = emfSingleton.getEm();
    }

    // List all
    public List<Person> findAll() {
        return em.createQuery("select c from Person c", Person.class).getResultList();
    }

    //Create
    public void create(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    //Update
    public void update(Person p) {
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }

    //Read
    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    //Delete
    public void delete(Person p) {
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
}
