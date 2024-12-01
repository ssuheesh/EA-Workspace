package com.sukhee.eacourse.lab3.repository;

import com.sukhee.eacourse.lab3.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class UserRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public UserRepository(EmfSingleton emfSingleton) {
        emf = emfSingleton.getEmf();
        em = emfSingleton.getEm();
    }

    private void startTransaction() {
        tx = em.getTransaction();
        tx.begin();
    }

    private void endTransaction() {
        tx.commit();
    }

    // Method to check if a User with a given username and password exists
    public boolean checkUserCredentials(String username, String password) {
        String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return !query.getResultList().isEmpty();
    }

    // Method to return the total number of users in the database
    public long getTotalUsers() {
        String jpql = "SELECT COUNT(u) FROM User u";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        return query.getSingleResult();
    }

}
