package com.sukhee.eacourse.lab2student.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;

public class EmfSingleton implements AutoCloseable {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static EmfSingleton instance;

    private EmfSingleton() {
        emf = Persistence.createEntityManagerFactory("Lab2Student_PU");
        em = emf.createEntityManager();
    }

    public static EmfSingleton getInstance() {
        if(instance == null) {
            instance = new EmfSingleton();
        }
        return instance;
    }

    public EntityManager getEm() {
        return em;
    }
    public EntityManagerFactory getEmf() {
        return emf;
    }

    @Override
    public void close() throws Exception {
        em.close();
        emf.close();
    }
}
