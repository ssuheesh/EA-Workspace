package com.sukhee.eacourse.lab2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfSingleton implements AutoCloseable {
    private final static String PU_NAME = "Lab2_PU";
    private static EmfSingleton instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private EmfSingleton() {
        emf = Persistence.createEntityManagerFactory(PU_NAME);
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
