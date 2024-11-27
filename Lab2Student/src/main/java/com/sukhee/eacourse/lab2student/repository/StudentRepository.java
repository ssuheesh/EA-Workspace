package com.sukhee.eacourse.lab2student.repository;

import com.sukhee.eacourse.lab2student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentRepository{
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public StudentRepository(EmfSingleton emfSingleton) {
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

    public void create(Student student) {
        startTransaction();
        em.persist(student);
        endTransaction();
    }

    public Student read(int id) {
        startTransaction();
        Student student= em.find(Student.class, id);
        endTransaction();
        return student;
    }

    public Student update(Student student) {
        startTransaction();
        Student databaseStudent= em.merge(student);
        endTransaction();
        return databaseStudent;
    }

    public Student anotherUpdate(Student student) {
        startTransaction();
        Student databaseStudet= em.find(Student.class, student.getId());
        databaseStudet.setName(student.getName());
        databaseStudet.setGpa(student.getGpa());
        endTransaction();
        return databaseStudet;
    }

    public void delete(Student student) {
        startTransaction();
        em.remove(student);
        endTransaction();
    }

}
