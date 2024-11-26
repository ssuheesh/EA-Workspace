package com.sukhee.eacourse.lab1.repository;

import com.sukhee.eacourse.lab1.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CarRepository {
    private static CarRepository instance;
    private final static String PU_NAME = "Lab1_PU";
    EntityManagerFactory emf;
    EntityManager em;

    private CarRepository() {
        emf = Persistence.createEntityManagerFactory(PU_NAME);
        em = emf.createEntityManager();
    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    // List all
    public List<Car> findAll() {
        return em.createQuery("select c from Car c", Car.class).getResultList();
    }

    //Create
    public void create(Car car) {
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
    }

    //Update
    public void update(Car car) {
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    //Read
    public Car findById(int id) {
        return em.find(Car.class, id);
    }

    //Delete
    public void delete(Car car) {
        em.getTransaction().begin();
        em.remove(car);
        em.getTransaction().commit();
    }
    public void destroy(){
        em.close();
        emf.close();
    }
}
