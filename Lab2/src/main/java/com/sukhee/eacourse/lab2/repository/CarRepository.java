package com.sukhee.eacourse.lab2.repository;

import com.sukhee.eacourse.lab2.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CarRepository {
    EntityManagerFactory emf;
    EntityManager em;

    public CarRepository(EmfSingleton emfSingleton) {
        emf = emfSingleton.getEmf();
        em = emfSingleton.getEm();
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
}
